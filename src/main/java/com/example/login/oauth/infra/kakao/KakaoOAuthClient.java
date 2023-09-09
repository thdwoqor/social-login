package com.example.login.oauth.infra.kakao;

import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.dto.OAuthUserInfo;
import com.example.login.oauth.infra.dto.OAuthCodeStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
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
    public String getAccessToken(final OAuthCodeStateDTO oauthCodeStateDTO) {
        KakaoAccessTokenRequest request = KakaoAccessTokenRequest.builder()
                .clientId(kakaoOauthConfig.getClientId())
                .redirectUri(kakaoOauthConfig.getRedirectUri())
                .grantType(kakaoOauthConfig.getGrantType())
                .code(oauthCodeStateDTO.code())
                .build();

        return kakaoAccessTokenClient.getKakaoToken(request).getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(String accessToken) {
        return kakaoUserInfoClient.getUserInfo("Bearer " + accessToken).toOAuthAttributes();
    }
}
