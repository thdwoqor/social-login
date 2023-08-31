package com.example.login.auth.kakao;

import com.example.login.SocialUser;
import lombok.Data;

@Data
public class KakaoUserInfoResponse {
    private String id;
    private KakaoAccount kakao_account;

    public SocialUser toSocialUser(){
        return new SocialUser(Long.valueOf(id), kakao_account.email, kakao_account.profile.nickname);
    }

    @Data
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Data
        public static class Profile {
            private String nickname;
        }
    }
}
