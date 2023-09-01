package com.example.login.oauth.controller;

import com.example.login.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService OAuthService;

    @GetMapping("/{providerName}/callback")
    public void googleLogin(
            @RequestParam("code") String code,
            @PathVariable("providerName") String providerName
    ) {
        String id = OAuthService.doSocialLogin(code, providerName);
        System.out.println(id);
    }
}


