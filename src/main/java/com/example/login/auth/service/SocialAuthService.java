package com.example.login.auth.service;

import com.example.login.SocialUser;

public interface SocialAuthService {

    boolean supports(String providerName);
    String getAccessToken(String code);
    SocialUser getUserInfo(String accessToken);
}
