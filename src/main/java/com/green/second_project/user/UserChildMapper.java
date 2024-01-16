package com.green.second_project.user;

import com.green.second_project.user.model.UserChildDto;
import com.green.second_project.user.model.UserChildProcDto;
import com.green.second_project.user.model.UserChildVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserChildMapper {
    int insUserChildren(UserChildDto list);
    List<UserChildVo> selUserChildren(int iuser);
    int delUserChildren(int iuser);
}
