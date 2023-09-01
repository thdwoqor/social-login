package com.example.login.auth.kakao;

import com.example.login.SocialUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoUserInfoResponse {

    private String id;
    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public SocialUser toSocialUser(){
        return new SocialUser(id, kakaoAccount.email, kakaoAccount.profile.nickname);
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
