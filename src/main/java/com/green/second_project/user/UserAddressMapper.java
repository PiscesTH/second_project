package com.green.second_project.user;

import com.green.second_project.user.model.UserSelAddressVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressMapper {
    List<UserSelAddressVo> selUserAddress(int iuser);
}
