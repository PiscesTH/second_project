package com.green.second_project.user;

import com.green.second_project.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpDto dto);
    UserSelMyInfoVo selMyInfo(int iuser);
    UserSignInProcDto selSignInInfoByUid(String uid);
    UserSelToModifyVo selUserInfoByIuser(int iuser);
    int delUser(int iuser);
    int updUser(UserUpdDto dto);
}
