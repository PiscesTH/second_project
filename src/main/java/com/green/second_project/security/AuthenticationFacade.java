package com.green.second_project.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public MyPrincipal getLoginUser() {
        return (MyPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public int getLoginUserPk() {
        return getLoginUser().getIuser();
    }
}
