package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDelAddressDto {
    @JsonIgnore
    private int iuser;
    private int iaddress;
}
