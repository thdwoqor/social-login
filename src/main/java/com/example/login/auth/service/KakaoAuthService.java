package com.example.login.auth.service;

import com.example.login.SocialUser;
import com.example.login.auth.kakao.KakaoAccessTokenRequest;
import com.example.login.auth.kakao.KakaoAccessTokenApi;
import com.example.login.auth.kakao.KakaoUserInfoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoAuthService implements SocialAuthService {

    @Value("${spring.auth.kakao.clientId}")
    private String clientId;
    @Value("${spring.auth.kakao.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.kakao.grantType}")
    private String grantType;

    private final KakaoAccessTokenApi kakaoAccessTokenApi;
    private final KakaoUserInfoApi kakaoUserInfoApi;

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

        return kakaoAccessTokenApi.getKakaoToken(request).getAccessToken();
    }

    @Override
    public SocialUser getUserInfo(String accessToken) {
        return kakaoUserInfoApi.getUserInfo("Bearer " + accessToken).toSocialUser();
    }
}
