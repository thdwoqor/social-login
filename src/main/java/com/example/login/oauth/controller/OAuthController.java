package com.example.login.oauth.controller;

import com.example.login.oauth.domain.uri.AuthorizationUriProviders;
import com.example.login.oauth.service.OAuthInfoDto;
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

    private final OAuthService oauthService;
    private final AuthorizationUriProviders authorizationUriProviders;

    @GetMapping("/{providerName}/callback")
    public void login(
            @RequestParam("code") String code,
            @RequestParam(value = "state", required = false) String state,
            @PathVariable("providerName") String providerName
    ) {
        OAuthInfoDto oauthParam = OAuthInfoDto.builder()
                .code(code)
                .state(state)
                .provider(providerName).build();
        String id = oauthService.doSocialLogin(oauthParam);
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


