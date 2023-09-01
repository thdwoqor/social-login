package com.example.login.oauth.controller;

import com.example.login.oauth.domain.uri.AuthorizationUriProviders;
import com.example.login.oauth.service.OAuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
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
    private final AuthorizationUriProviders authorizationUriProviders;

    @GetMapping("/{providerName}/callback")
    public void login(
            @RequestParam("code") String code,
            @PathVariable("providerName") String providerName
    ) {
        String id = OAuthService.doSocialLogin(code, providerName);
        System.out.println(id);
    }

    @SneakyThrows
    @GetMapping("/{providerName}")
    public ResponseEntity<String> redirectAuthUrl(
            @PathVariable("providerName") String providerName,
            HttpServletResponse response
    ) {
        String uri = authorizationUriProviders.getUri(providerName);
        response.sendRedirect(uri);
        return ResponseEntity.ok().build();
    }
}


