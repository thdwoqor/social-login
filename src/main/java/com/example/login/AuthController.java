package com.example.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/{providerName}/callback")
    public void googleLogin(
            @RequestParam("code") String code,
            @PathVariable("providerName") String providerName
    ) {
        String id = userService.doSocialLogin(code, providerName);
        System.out.println(id);
    }
}


