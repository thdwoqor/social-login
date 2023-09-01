package com.example.login.oauth.infra.google;

import com.example.login.oauth.infra.dto.OAuthUserInfo;
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
