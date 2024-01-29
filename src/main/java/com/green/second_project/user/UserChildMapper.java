package com.green.second_project.user;

import com.green.second_project.user.model.UserChildDto;
import com.green.second_project.user.model.UserChildProcDto;
import com.green.second_project.user.model.UserChildVo;
import com.green.second_project.user.model.UserSignUpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserChildMapper {
    int insUserChildren(UserChildDto dto);
    List<UserChildVo> selUserChildren(int iuser);
    int delUserChildren(int iuser);
    int insUserChildren2(UserSignUpDto dto);
}
