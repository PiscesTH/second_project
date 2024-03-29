package com.green.second_project.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.second_project.common.Const;
import com.green.second_project.validation.ValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

import static com.green.second_project.common.Const.*;

@Data
@Schema(title = "회원가입 시 필요한 고객 요청 데이터")
public class UserSignUpDto {
    @JsonIgnore
    private int iuser;

    @Schema(description = "유저 아이디", example = "Test1234")
    @NotNull(message = ID_IS_BLANK/*, groups = ValidationGroup.NotNullGroup.class*/)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,10}$",
            message = NOT_ALLOWED_ID/*,
            groups = ValidationGroup.PatternCheckGroup.class*/)
    private String uid;

    @Schema(description = "유저 비밀번호", example = "특수문자는 @$!%*?&#~_-를 사용할 수 있습니다.")
    @NotNull(message = PASSWORD_IS_BLANK/*, groups = ValidationGroup.NotNullGroup.class*/)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#~_-])[A-Za-z\\d@$!%*?&#.~_-]{8,16}$",
            message = NOT_ALLOWED_PASSWORD/*,
            groups = ValidationGroup.PatternCheckGroup.class*/)
    private String upw;

    @NotBlank(message = NM_IS_BLANK/*, groups = ValidationGroup.NotBlankGroup.class*/)
    private String nm;

    @NotBlank(message = ZIP_CODE_IS_BLANK/*, groups = ValidationGroup.NotBlankGroup.class*/)
    private String zipCode;

    @NotBlank(message = ADDRESS_IS_BLANK/*, groups = ValidationGroup.NotBlankGroup.class*/)
    private String address;

    @NotBlank(message = ADDRESS_DETAIL_IS_BLANK/*, groups = ValidationGroup.NotBlankGroup.class*/)
    private String addressDetail;

    @NotNull(message = PHONE_NUMBER_IS_BLANK/*, groups = ValidationGroup.NotNullGroup.class*/)
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}",
            message = NOT_ALLOWED_PHONE_NUMBER)
    private String phoneNumber;

    @NotNull(message = EMAIL_IS_BLANK/*, groups = ValidationGroup.NotNullGroup.class*/)
    @Pattern(regexp = "\\w+@\\w{3,}\\.([a-zA-Z]{2,}|[a-zA-Z]{2,}\\.[a-zA-Z]{2,})",
            message = NOT_ALLOWED_EMAIL)
    private String email;

    @Size(min = 1, max = 3, message = NOT_ALLOWED_CHILDREN_COUNT)
    private List<@Valid UserChildDto> children;
}
