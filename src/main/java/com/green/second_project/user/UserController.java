package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.UserSelMyInfoVo;
import com.green.second_project.user.model.UserSignInDto;
import com.green.second_project.user.model.UserSignInVo;
import com.green.second_project.user.model.UserSignUpDto;
import jakarta.servlet.http.HttpServletResponse;
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
    public ResVo postSignUp(@RequestBody UserSignUpDto dto){
        return service.postSignUp(dto);
    }

    @PostMapping("/sign-in")
    public UserSignInVo postSignIn(HttpServletResponse res, @RequestBody UserSignInDto dto){
        return null;
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
