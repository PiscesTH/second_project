package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserSelMyInfoVo;
import com.green.second_project.user.model.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/sign-up")
    public ResVo postSignIn(@RequestBody UserSignUpDto dto){
        return service.postSignIn(dto);
    }

    @GetMapping("/my-page")
    public UserSelMyInfoVo getMyInfo() {
        return service.getMyInfo();
    }

    @PostMapping("/sign-in")
    public ResVo postSignUp() {
        return null;
    }
}
