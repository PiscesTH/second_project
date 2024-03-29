package com.green.second_project.user.model;

import com.green.second_project.common.Const;
import com.green.second_project.validation.ValidationGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserCheckUidDto {
    @NotNull(message = Const.NM_IS_BLANK/*, groups = ValidationGroup.NotNullGroup.class*/)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$",
            message = "아이디는 공백을 제외한 영어나 숫자로 이루어진 4~10자리이어야 합니다."/*,
            groups = ValidationGroup.PatternCheckGroup.class*/)
    private String uid;
}
