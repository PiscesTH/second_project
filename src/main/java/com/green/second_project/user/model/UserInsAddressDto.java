package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInsAddressDto {
    @JsonIgnore
    private int iuser;
    private String zipCode;
    private String address;
    private String addressDetail;
}
