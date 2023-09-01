package com.example.login.oauth.domain.client;

import com.example.login.oauth.infra.OAuthUserInfo;

public interface OAuthClient {

    boolean supports(String providerName);
    String getAccessToken(String code);
    OAuthUserInfo getUserInfo(String accessToken);
}
