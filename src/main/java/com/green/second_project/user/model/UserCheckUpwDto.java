package com.green.second_project.user.model;

import com.green.second_project.common.Const;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCheckUpwDto {
    @NotBlank(message = Const.PASSWORD_IS_BLANK)
    private String upw;
}
