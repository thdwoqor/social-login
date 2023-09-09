package com.example.login.oauth.domain.client;

import com.example.login.oauth.infra.dto.OAuthUserInfo;
import com.example.login.oauth.infra.dto.OAuthCodeStateDTO;

public interface OAuthClient {

    boolean supports(String providerName);
    String getAccessToken(OAuthCodeStateDTO oauthCodeStateDTO);
    OAuthUserInfo getUserInfo(String accessToken);
}
