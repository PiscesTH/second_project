package com.green.second_project.user;

import com.green.second_project.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpDto dto);
    UserSelMyInfoVo selMyInfo(int iuser);
    UserSignInProcDto selSignInInfoByUid(String uid);
    String selUpwByIuser(int iuser);
}
