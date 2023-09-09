package com.example.login.oauth.infra.naver;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NaverUserInfoResponse {

    private String resultcode;
    private String message;
    private Response response;

    @Data
    @NoArgsConstructor
    public static class Response{

        private String id;
        private String email;
        private String name;
    }
}
