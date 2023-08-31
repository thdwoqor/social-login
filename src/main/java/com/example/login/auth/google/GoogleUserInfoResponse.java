package com.example.login.auth.google;

import com.example.login.SocialUser;
import lombok.Data;

@Data
public class GoogleUserInfoResponse {

    String id;
    String email;
    String name;

    public SocialUser toSocialUser() {
        return new SocialUser(Long.valueOf(id), email, name);
    }
}
