package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.*;
import com.green.second_project.validation.ValidationSequence;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @GetMapping("/sign-up")
    public List<UserClauseVo> getClause() {
        return service.getClause();
    }

    @PostMapping("/sign-up")
    public ResVo postSignUp(@Validated(ValidationSequence.class) @RequestBody UserSignUpDto dto) {
        return service.postSignUp(dto);
    }

    @PostMapping("/sign-up/check")
    public ResVo postCheckUid(@Validated(ValidationSequence.class) @RequestBody UserCheckUidDto dto) {
        log.info("uid : {}",dto);
        return service.postCheckUid(dto);
    }

    @PostMapping("/sign-in")
    public UserSignInVo postSignIn(HttpServletResponse res,@Valid @RequestBody UserSignInDto dto) {
        return service.postSignIn(res, dto);
    }

    @GetMapping("/my-page")
    public UserSelMyInfoVo getMyInfo() {
        return service.getMyInfo();
    }

    @PostMapping("/modify")
    public UserSelToModifyVo postCheckUpw(@Valid @RequestBody UserCheckUpwDto dto) {
        return service.postCheckUpw(dto);
    }

    @PutMapping("/modify")
    public ResVo putUserInfo(@Validated(ValidationSequence.class) @RequestBody UserUpdDto dto) {
        return service.putUserInfo(dto);
    }

    @DeleteMapping("/modify")
    public ResVo unregister() {
        return service.unregister();
    }



}
