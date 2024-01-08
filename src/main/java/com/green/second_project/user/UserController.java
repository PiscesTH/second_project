package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResVo postSignin(@RequestBody UserSigninDto dto){
        return service.postSignin(dto);
    }
}
