package com.example.login.oauth.infra.kakao;

import com.example.login.oauth.domain.uri.AuthorizationUriProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class KakaoAuthorizationUriProviderProvider implements AuthorizationUriProvider {

    private final KakaoOauthConfig kakaoOauthConfig;

    @Override
    public boolean supports(final String providerName) {
        return kakaoOauthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getUri() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("kauth.kakao.com")
                .path("/oauth/authorize")
                .queryParam("scope", kakaoOauthConfig.getScope())
                .queryParam("client_id", kakaoOauthConfig.getClientId())
                .queryParam("redirect_uri", kakaoOauthConfig.getRedirectUri())
                .queryParam("response_type", "code")
                .build()
                .toString();
    }
}
