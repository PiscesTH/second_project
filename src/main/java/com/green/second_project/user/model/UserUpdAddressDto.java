package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.second_project.common.Const;
import com.green.second_project.exception.AuthErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class UserUpdAddressDto {
    @JsonIgnore
    private int iuser;

    @Positive
    private int iaddress;

    @NotBlank(message = Const.NOT_ALLOWED_ZIP_CODE)
    private String zipCode;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS)
    private String address;

    @NotBlank(message = Const.NOT_ALLOWED_ADDRESS_DETAIL)
    private String addressDetail;
}
