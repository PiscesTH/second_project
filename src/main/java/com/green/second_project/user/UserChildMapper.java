package com.green.second_project.user;

import com.green.second_project.user.model.UserChildDto;
import com.green.second_project.user.model.UserChildProcDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserChildMapper {
    int insUserChildren(UserChildProcDto list);
    List<UserChildDto> selUserChildren(int iuser);
}
