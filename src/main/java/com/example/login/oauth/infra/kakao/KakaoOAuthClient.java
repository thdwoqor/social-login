package com.example.login.oauth.infra.kakao;

import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.dto.OAuthUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoOAuthClient implements OAuthClient {

    private final KakaoOauthConfig kakaoOauthConfig;
    private final KakaoAccessTokenClient kakaoAccessTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    @Override
    public boolean supports(final String providerName) {
        return kakaoOauthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getAccessToken(String code) {
        KakaoAccessTokenRequest request = KakaoAccessTokenRequest.builder()
                .clientId(kakaoOauthConfig.getClientId())
                .redirectUri(kakaoOauthConfig.getRedirectUri())
                .grantType(kakaoOauthConfig.getGrantType())
                .code(code)
                .build();

        return kakaoAccessTokenClient.getKakaoToken(request).getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(String accessToken) {
        return kakaoUserInfoClient.getUserInfo("Bearer " + accessToken).toOAuthAttributes();
    }
}
