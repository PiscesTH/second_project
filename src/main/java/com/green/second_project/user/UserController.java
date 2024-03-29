package com.green.second_project.user;

import com.green.second_project.common.ResVo;
import com.green.second_project.user.model.*;
import com.green.second_project.validation.ValidationSequence;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResVo postSignUp(@Valid @RequestBody UserSignUpDto dto) {
        return service.postSignUp(dto);
    }

    @Operation(summary = "회원 가입 시 닉네임 중복 확인 기능", description = """
            중복되는 닉네임 없음 -> result = 1
            """)
    @PostMapping("/sign-up/check")
    public ResVo postCheckUid(@Valid @RequestBody UserCheckUidDto dto) {
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
    @Operation(summary = "회원 정보 수정 전 비밀번호 확인 기능", description = """
            비밀번호 일치 -> result = 1<br>
            비밀번호 불일치 -> error 코드 응답
            """)
    public UserSelToModifyVo postCheckUpw(@Valid @RequestBody UserCheckUpwDto dto) {
        return service.postCheckUpw(dto);
    }

    @PutMapping("/modify")
    public ResVo putUserInfo(@Valid @RequestBody UserUpdDto dto) {
        return service.putUserInfo(dto);
    }

    @DeleteMapping("/modify")
    public ResVo unregister() {
        return service.unregister();
    }

    @PostMapping("/signout")
    public ResVo postSignout(HttpServletRequest req, HttpServletResponse res) {
        return service.signout(res);
    }
}
