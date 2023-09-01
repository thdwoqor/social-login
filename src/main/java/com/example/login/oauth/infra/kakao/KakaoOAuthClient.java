package com.example.login.oauth.infra.kakao;

import com.example.login.oauth.infra.OAuthUserInfo;
import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoOAuthClient implements OAuthClient {

    @Value("${spring.auth.kakao.clientId}")
    private String clientId;
    @Value("${spring.auth.kakao.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.kakao.grantType}")
    private String grantType;

    private final KakaoAccessTokenClient kakaoAccessTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    @Override
    public boolean supports(final String providerName) {
        return Provider.KAKAO==Provider.from(providerName);
    }

    @Override
    public String getAccessToken(String code) {
        KakaoAccessTokenRequest request = KakaoAccessTokenRequest.builder()
                .clientId(clientId)
                .redirectUri(redirectUri)
                .grantType(grantType)
                .code(code)
                .build();

        return kakaoAccessTokenClient.getKakaoToken(request).getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(String accessToken) {
        return kakaoUserInfoClient.getUserInfo("Bearer " + accessToken).toOAuthAttributes();
    }
}
