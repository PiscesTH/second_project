package com.green.second_project.user;

import com.green.second_project.common.AppProperties;
import com.green.second_project.common.Const;
import com.green.second_project.common.MyCookieUtils;
import com.green.second_project.common.ResVo;
import com.green.second_project.exception.AuthErrorCode;
import com.green.second_project.exception.CommonErrorCode;
import com.green.second_project.exception.RestApiException;
import com.green.second_project.product.ProductWishListMapper;
import com.green.second_project.product.model.ProductSelWishListVo;
import com.green.second_project.security.AuthenticationFacade;
import com.green.second_project.security.JwtTokenProvider;
import com.green.second_project.security.MyPrincipal;
import com.green.second_project.user.model.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final ProductWishListMapper wishListMapper;
    private final UserAddressMapper addressMapper;
    private final UserChildMapper childMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final MyCookieUtils myCookieUtils;
    private final AuthenticationFacade authenticationFacade;

    public ResVo postSignUp(UserSignUpDto dto) {
        UserSignInProcDto procDto = userMapper.selSignInInfoByUid(dto.getUid());
        if (procDto != null) {
            throw new RestApiException(AuthErrorCode.DUPLICATED_UID);
        }
        String hashedUpw = passwordEncoder.encode(dto.getUpw());
        dto.setUpw(hashedUpw);
        int insUserResult = userMapper.insUser(dto);

        /*for (UserChildDto child : dto.getChildren()) {
            child.setIuser(dto.getIuser());
            int insChildResult = childMapper.insUserChildren(child);
        }*/
        int insChildResult = childMapper.insUserChildren2(dto);

        UserInsAddressDto addressDto = new UserInsAddressDto(dto);
        int insAddressResult = addressMapper.insUserAddress(addressDto);

        return new ResVo(dto.getIuser());
    }

    public ResVo postCheckUid(UserCheckUidDto dto) {
        UserSignInProcDto result = userMapper.selSignInInfoByUid(dto.getUid());
        if (result != null) {
            throw new RestApiException(AuthErrorCode.DUPLICATED_UID);
        }
        return new ResVo(Const.SUCCESS);
    }

    public UserSelMyInfoVo getMyInfo() {
        int iuser = authenticationFacade.getLoginUserPk();
        UserSelMyInfoVo myInfoVo = userMapper.selMyInfo(iuser);
        List<ProductSelWishListVo> wishList = wishListMapper.selWishList(iuser);
        myInfoVo.setMyWishList(wishList);
        return myInfoVo;
    }

    public UserSignInVo postSignIn(HttpServletResponse res, UserSignInDto dto) {
        UserSignInProcDto vo = userMapper.selSignInInfoByUid(dto.getUid());
        if (vo == null || !passwordEncoder.matches(dto.getUpw(), vo.getUpw())) {
            throw new RestApiException(AuthErrorCode.LOGIN_FAIL);
        }
        MyPrincipal myPrincipal = new MyPrincipal(vo.getIuser());
        String at = jwtTokenProvider.generateAccessToken(myPrincipal);
        String rt = jwtTokenProvider.generateRefreshToken(myPrincipal);

        int rtCookieMaxAge = appProperties.getJwt().getRefreshCookieMaxAge();
        myCookieUtils.deleteCookie(res, "refreshToken");
        myCookieUtils.setCookie(res, "refreshToken", rt, rtCookieMaxAge);

        return UserSignInVo.builder()
                .result(Const.SIGN_IN_SUCCESS)
                .accessToken(at)
                .nm(vo.getNm())
                .build();
    }

    public UserSelToModifyVo postCheckUpw(UserCheckUpwDto dto) {
        int iuser = authenticationFacade.getLoginUserPk();
        UserSelToModifyVo vo = userMapper.selUserInfoByIuser(iuser);
        String hashedUpw = vo.getUpw();
        if (!passwordEncoder.matches(dto.getUpw(), hashedUpw)) {
            throw new RestApiException(AuthErrorCode.PASSWORD_NOT_MATCHED);
        }
        vo.setChildren(childMapper.selUserChildren(iuser));
        vo.setResult(Const.SIGN_IN_SUCCESS);
        return vo;
    }

    public List<UserSelAddressVo> getUserAddress() {
        int iuser = authenticationFacade.getLoginUserPk();
        return addressMapper.selUserAddress(iuser);
    }

    public ResVo putUserAddress(UserUpdAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        int result = addressMapper.updUserAddress(dto);
        if (result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo postUserAddress(UserInsAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<UserSelAddressVo> vo = addressMapper.selUserAddress(dto.getIuser());
        if (vo.size() == 3) {
            throw new RestApiException(AuthErrorCode.INVALID_ADDRESS_SIZE);
        }
        int result = addressMapper.insUserAddress(dto);
        return new ResVo(result);
    }

    public ResVo delUserAddress(UserDelAddressDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        int result = addressMapper.delUserAddress(dto);
        return new ResVo(result);
    }

    public ResVo unregister() {
        int iuser = authenticationFacade.getLoginUserPk();
        int result = userMapper.delUser(iuser);
        return new ResVo(result);
    }

    public ResVo putUserInfo(UserUpdDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        if (StringUtils.hasText(dto.getUpw())) {
            String hashedUpw = passwordEncoder.encode(dto.getUpw());
            dto.setUpw(hashedUpw);
        }
        int delChildResult = childMapper.delUserChildren(dto.getIuser());
        for (UserChildDto child : dto.getChildren()) {
//            child.setIuser(dto.getIuser());
            int insChildResult = childMapper.insUserChildren(child);
        }
        int result = userMapper.updUser(dto);
        return new ResVo(result);
    }

    public List<UserClauseVo> getClause() {
        return userMapper.selClause();
    }

    public ResVo signout(HttpServletResponse res) {
        myCookieUtils.deleteCookie(res, "refreshToken");
        return new ResVo(Const.SUCCESS);
    }
}
