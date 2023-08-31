package com.example.login.auth;

import com.example.login.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/google/callback")
    public void googleLogin(@RequestParam("code") String code) {
        Long id = userService.doGoogleLogin(code);
        System.out.println(id);
    }
}


