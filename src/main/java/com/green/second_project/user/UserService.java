package com.green.second_project.user;

import com.green.second_project.common.AppProperties;
import com.green.second_project.common.Const;
import com.green.second_project.common.MyCookieUtils;
import com.green.second_project.common.ResVo;
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

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final ProductWishListMapper wishListMapper;
    private final UserAddressMapper addressMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final MyCookieUtils myCookieUtils;
    private final AuthenticationFacade authenticationFacade;

    public ResVo postSignUp(UserSignUpDto dto){
        String hashedUpw = passwordEncoder.encode(dto.getUpw());
        dto.setUpw(hashedUpw);
        int insUserResult = userMapper.insUser(dto);
        int insAddressResult = userMapper.insUserAddress(dto);
        return new ResVo(dto.getIuser());
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
        if (vo == null) {
            return UserSignInVo.builder()
                    .result(Const.UID_NOT_EXIST)
                    .build();
        }
        if(!passwordEncoder.matches(dto.getUpw(), vo.getUpw())){
            return UserSignInVo.builder()
                    .result(Const.UPW_NOT_MATCHED)
                    .build();
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

    public ResVo postCheckUpw(UserCheckUpwDto dto) {
        int iuser = authenticationFacade.getLoginUserPk();
        String hashedUpw = userMapper.selUpwByIuser(iuser);
        if (passwordEncoder.matches(dto.getUpw(), hashedUpw)) {
            return new ResVo(Const.SIGN_IN_SUCCESS);
        }
        return new ResVo(Const.UPW_NOT_MATCHED);
    }

    public List<UserSelAddressVo> getUserAddress() {
        int iuser = authenticationFacade.getLoginUserPk();
        return addressMapper.selUserAddress(iuser);
    }
}
