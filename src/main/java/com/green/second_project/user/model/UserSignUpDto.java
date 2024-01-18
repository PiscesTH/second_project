package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "회원가입 시 필요한 고객 요청 데이터")
public class UserSignUpDto {
    @JsonIgnore
    private int iuser;
    @NotEmpty(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$",
            message = "아이디는 공백을 제외한 영어나 숫자로 이루어진 4~10자리이어야 합니다.")
    private String uid;

    private String upw;
    private String nm;

    private String zipCode;
    private String address;
    private String addressDetail;
    private String phoneNumber;
    private String email;
    private List<UserChildDto> children;
}
