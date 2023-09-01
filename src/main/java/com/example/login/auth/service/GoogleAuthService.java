package com.example.login.auth.service;

import com.example.login.SocialUser;
import com.example.login.auth.google.GoogleAccessTokenRequest;
import com.example.login.auth.google.GoogleAccessTokenApi;
import com.example.login.auth.google.GoogleUserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleAuthService implements SocialAuthService {

    @Value("${spring.auth.google.clientId}")
    private String clientId;
    @Value("${spring.auth.google.clientSecret}")
    private String clientSecret;
    @Value("${spring.auth.google.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.google.grantType}")
    private String grantType;

    private final GoogleAccessTokenApi googleAccessTokenApi;
    private final GoogleUserApi googleUserApi;

    @Override
    public boolean supports(final String providerName) {
        return Provider.GOOGLE==Provider.from(providerName);
    }

    @Override
    public String getAccessToken(String code) {
        GoogleAccessTokenRequest request = GoogleAccessTokenRequest.builder()
                .redirectUri(redirectUri)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(grantType)
                .code(code).build();

        return googleAccessTokenApi.getGoogleToken(request).getAccessToken();
    }

    @Override
    public SocialUser getUserInfo(String accessToken) {
        return googleUserApi.getUserInfo(accessToken).toSocialUser();
    }
}
