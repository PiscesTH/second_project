package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.second_project.common.Const;
import com.green.second_project.validation.UpdUpwConstraint;
import com.green.second_project.validation.ValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UserUpdDto {
    @JsonIgnore
    private int iuser;

    @Schema(description = "유저 비밀번호", example = "특수문자는 @$!%*?&#~_-를 사용할 수 있습니다.")
    @UpdUpwConstraint
    private String upw;


    @NotBlank(message = "닉네임을 입력해주세요.", groups = ValidationGroup.NotBlankGroup.class)
    private String nm;

    @NotNull(message = "전화번호를 입력해주세요.", groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}",
            message = "올바르지 않은 전화번호 형식입니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String phoneNumber;

    @NotNull(message = "이메일을 입력해주세요.", groups = ValidationGroup.NotNullGroup.class)
    @Pattern(regexp = "\\w+@\\w{3,}\\.([a-zA-Z]{2,}|[a-zA-Z]{2,}\\.[a-zA-Z]{2,})",
            message = "올바르지 않은 이메일 형식입니다.",
            groups = ValidationGroup.PatternCheckGroup.class)
    private String email;

    @Size(min = 1, max = 3, message = "아이 정보는 최소 1명 최대 3명까지 입력할 수 있습니다.")
    private List<@Valid UserChildDto> children;
}
