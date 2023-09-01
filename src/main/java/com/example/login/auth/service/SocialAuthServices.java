package com.example.login.auth.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialAuthServices {

    private final List<SocialAuthService> socialAuthServices;

    public SocialAuthService getSocialAuthService(final String provider) {
        return socialAuthServices.stream()
                .filter(socialAuthService -> socialAuthService.supports(provider))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provider가 존재하지 않습니다."));
    }
}
