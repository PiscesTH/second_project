package com.green.second_project.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserSignInDto {
    @Schema(defaultValue = "hubble")
    private String uid;
    @Schema(defaultValue = "xptmxm123")
    private String upw;
}
