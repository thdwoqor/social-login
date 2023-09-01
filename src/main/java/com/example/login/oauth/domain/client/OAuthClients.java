package com.example.login.oauth.domain.client;

import com.example.login.oauth.infra.OAuthUserInfo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthClients {

    private final List<OAuthClient> OAuthClients;

    private OAuthClient getSocialAuthService(final String provider) {
        return OAuthClients.stream()
                .filter(OAuthClient -> OAuthClient.supports(provider))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 소셜 로그인입니다."));
    }

    public OAuthUserInfo getUserInfo(final String code, final String provider){
        OAuthClient oauthClient = getSocialAuthService(provider);
        String accessToken = oauthClient.getAccessToken(code);
        return oauthClient.getUserInfo(accessToken);
    }
}
