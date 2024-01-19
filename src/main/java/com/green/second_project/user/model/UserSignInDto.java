package com.green.second_project.user.model;

import com.green.second_project.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserSignInDto {
    @Schema(defaultValue = "hubble")
    @NotBlank(message = Const.NM_IS_BLANK)
    private String uid;
    @Schema(defaultValue = "xptmxm123")
    @NotBlank(message = Const.PASSWORD_IS_BLANK)
    private String upw;
}
