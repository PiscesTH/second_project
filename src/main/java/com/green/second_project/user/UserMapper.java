package com.green.second_project.user;

import com.green.second_project.user.model.UserSelMyInfoVo;
import com.green.second_project.user.model.UserSignUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpDto dto);
    int insUserAddress(UserSignUpDto dto);
    UserSelMyInfoVo selMyInfo(int iuser);
}
