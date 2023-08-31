package com.example.login;

import com.example.login.auth.google.GoogleAccessTokenRequest;
import com.example.login.auth.google.GoogleAccessTokenResponse;
import com.example.login.auth.google.GoogleTokenApi;
import com.example.login.auth.google.GoogleUserApi;
import com.example.login.auth.google.GoogleUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleLoginServiceImpl {

    @Value("${spring.auth.google.clientId}")
    private String clientId;
    @Value("${spring.auth.google.clientSecret}")
    private String clientSecret;
    @Value("${spring.auth.google.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.google.grantType}")
    private String grantType;

    private final GoogleTokenApi googleTokenApi;
    private final GoogleUserApi googleUserApi;

    public GoogleAccessTokenResponse getAccessToken(String code) {
        GoogleAccessTokenRequest request = GoogleAccessTokenRequest.builder()
                .redirect_uri(redirectUri)
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type(grantType)
                .code(code).build();

        return googleTokenApi.getGoogleToken(request);
    }

    public GoogleUserInfoResponse getUserInfo(String accessToken) {
        return googleUserApi.getUserInfo(accessToken);
    }
}
