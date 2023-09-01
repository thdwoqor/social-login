package com.example.login;

import com.example.login.auth.kakao.KakaoAccessTokenRequest;
import com.example.login.auth.kakao.KakaoAccessTokenResponse;
import com.example.login.auth.kakao.KakaoTokenApi;
import com.example.login.auth.kakao.KakaoUserInfoApi;
import com.example.login.auth.kakao.KakaoUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoLoginServiceImpl {

    @Value("${spring.auth.kakao.clientId}")
    private String clientId;
    @Value("${spring.auth.kakao.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.kakao.grantType}")
    private String grantType;

    private final KakaoTokenApi kakaoTokenApi;
    private final KakaoUserInfoApi kakaoUserInfoApi;

    public KakaoAccessTokenResponse getAccessToken(String code) {
        KakaoAccessTokenRequest request = KakaoAccessTokenRequest.builder()
                .clientId(clientId)
                .redirectUri(redirectUri)
                .grantType(grantType)
                .code(code)
                .build();

        return kakaoTokenApi.getKakaoToken(request);
    }

    public KakaoUserInfoResponse getUserInfo(String accessToken) {
        return kakaoUserInfoApi.getUserInfo("Bearer " + accessToken);
    }
}
