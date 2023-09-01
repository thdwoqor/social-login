package com.example.login.oauth.infra.google;

import com.example.login.oauth.infra.OAuthUserInfo;
import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleOAuthClient implements OAuthClient {

    @Value("${spring.auth.google.clientId}")
    private String clientId;
    @Value("${spring.auth.google.clientSecret}")
    private String clientSecret;
    @Value("${spring.auth.google.redirectUri}")
    private String redirectUri;
    @Value("${spring.auth.google.grantType}")
    private String grantType;

    private final GoogleAccessTokenClient googleAccessTokenClient;
    private final GoogleUserInfoClient googleUserInfoClient;

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

        return googleAccessTokenClient.getGoogleToken(request).getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(String accessToken) {
        return googleUserInfoClient.getUserInfo(accessToken).toOAuthAttributes();
    }
}
