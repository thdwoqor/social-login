package com.example.login.oauth.infra.google;

import com.example.login.oauth.infra.OAuthUserInfo;
import lombok.Data;

@Data
public class GoogleUserInfoResponse {

    String id;
    String email;
    String name;

    public OAuthUserInfo toOAuthAttributes() {
        return new OAuthUserInfo(id, email, name);
    }
}
