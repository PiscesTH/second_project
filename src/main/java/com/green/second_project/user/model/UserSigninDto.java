package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "회원가입 시 필요한 고객 요청 데이터")
public class UserSigninDto {
    @JsonIgnore
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String phoneNumber;
    private String email;
}
