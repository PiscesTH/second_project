package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.*;
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
    public ResVo postSignUp(@RequestBody UserSignUpDto dto) {
        return service.postSignUp(dto);
    }

    @PostMapping("/sign-in")
    public UserSignInVo postSignIn(HttpServletResponse res, @RequestBody UserSignInDto dto) {
        return service.postSignIn(res, dto);
    }

    @GetMapping("/my-page")
    public UserSelMyInfoVo getMyInfo() {
        return service.getMyInfo();
    }

    @PostMapping("/modify")
    public UserSelToModifyVo postCheckUpw(@RequestBody UserCheckUpwDto dto) {
        return service.postCheckUpw(dto);
    }

    @PutMapping("/modify")
    public ResVo putUserInfo(@RequestBody UserUpdDto dto) {
        return service.putUserInfo(dto);
    }

    @DeleteMapping("/modify")
    public ResVo unregister() {
        return service.unregister();
    }
}
