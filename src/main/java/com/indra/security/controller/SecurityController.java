package com.indra.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String getData(HttpServletRequest httpServletRequest){
        return "Hi from security "+httpServletRequest.getSession().getId();
    }
}
