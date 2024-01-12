package com.green.second_project.user;

import com.green.second_project.user.model.UserSelMyInfoVo;
import com.green.second_project.user.model.UserSigninDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSigninDto dto);
    int insUserAddress(UserSigninDto dto);
    UserSelMyInfoVo selMyInfo(int iuser);
}
