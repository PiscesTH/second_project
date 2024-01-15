package com.green.second_project.user.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class UserSelAddressVo {
    private String zipCode;
    private String address;
    private String addressDetail;
}
