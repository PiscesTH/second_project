package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.product.ProductWishListMapper;
import com.green.second_project.product.model.ProductSelWishListVo;
import com.green.second_project.user.model.UserSelMyInfoVo;
import com.green.second_project.user.model.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final ProductWishListMapper wishListMapper;

    public ResVo postSignIn(UserSignUpDto dto){
        int insUserResult = userMapper.insUser(dto);
        int insAddressResult = userMapper.insUserAddress(dto);
        return new ResVo(dto.getIuser());
    }

    public UserSelMyInfoVo getMyInfo() {
        int iuser = 1;  //임시
        UserSelMyInfoVo myInfoVo = userMapper.selMyInfo(iuser);
        List<ProductSelWishListVo> wishList = wishListMapper.selWishList(iuser);
        myInfoVo.setMyWishList(wishList);
        return myInfoVo;
    }
}
