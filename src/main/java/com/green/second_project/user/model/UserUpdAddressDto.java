package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.second_project.common.Const;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserUpdAddressDto {
    @JsonIgnore
    private int iuser;

    @Positive
    private int iaddress;

    @NotBlank(message = Const.ZIP_CODE_IS_BLANK)
    private String zipCode;

    @NotBlank(message = Const.ADDRESS_IS_BLANK)
    private String address;

    @NotBlank(message = Const.ADDRESS_DETAIL_IS_BLANK)
    private String addressDetail;
}
