package com.example.login.oauth.infra.dto;

import com.example.login.oauth.domain.OAuthUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OAuthUserInfo {

    private String id;
    private String email;
    private String nickname;

    public OAuthUser toOAuthUser(){
        return new OAuthUser(id, email, nickname);
    }
}
