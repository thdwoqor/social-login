package com.example.login.oauth.domain.uri;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationUriProviders {

    private final List<AuthorizationUriProvider> authorizationUrisProviders;

    private AuthorizationUriProvider getSocialAuthService(final String provider) {
        return authorizationUrisProviders.stream()
                .filter(authorizationUriProvider -> authorizationUriProvider.supports(provider))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 소셜 로그인입니다."));
    }

    public String getUri(final String providerName){
        AuthorizationUriProvider authorizationUriProvider = getSocialAuthService(providerName);
        return authorizationUriProvider.getUri();
    }
}
