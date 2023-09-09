package com.example.login.oauth.infra.google;

import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.dto.OAuthUserInfo;
import com.example.login.oauth.infra.dto.OAuthCodeStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleOAuthClient implements OAuthClient {

    private final GoogleOAuthConfig googleOAuthConfig;
    private final GoogleAccessTokenClient googleAccessTokenClient;
    private final GoogleUserInfoClient googleUserInfoClient;

    @Override
    public boolean supports(final String providerName) {
        return googleOAuthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getAccessToken(final OAuthCodeStateDTO oauthCodeStateDTO) {
        GoogleAccessTokenRequest request = GoogleAccessTokenRequest.builder()
                .redirectUri(googleOAuthConfig.getRedirectUri())
                .clientId(googleOAuthConfig.getClientId())
                .clientSecret(googleOAuthConfig.getClientSecret())
                .grantType(googleOAuthConfig.getGrantType())
                .code(oauthCodeStateDTO.code()).build();

        return googleAccessTokenClient.getGoogleToken(request).getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(String accessToken) {
        return googleUserInfoClient.getUserInfo(accessToken).toOAuthAttributes();
    }
}
