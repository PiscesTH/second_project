package com.green.second_project.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode{ //enum : Const 대체 할 수 있음.
    UID_DUPLICATED(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디입니다."),
    NOT_EXIST_USER_ID(HttpStatus.NOT_FOUND, "아이디가 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.NOT_FOUND, "비밀번호를 확인해 주세요."),
    NEED_SIGNIN(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."),    //추가하고 싶으면 , 사용
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.NOT_FOUND, "refresh-token 이 없습니다.");
    //NOT_FOUND_REFRESH_TOKEN 가 멤버필드. -> 타입은 AuthErrorCode. 생성자를 통해서 값 주입

    private final HttpStatus httpStatus;
    private final String message;
    //enum은 name() 메서드를 자체적으로 구현 하고 있음. -> 오버라이딩 할 필요는 x
}
