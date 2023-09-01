package com.example.login.auth.kakao;

import feign.form.FormProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

//https://github.com/micronaut-projects/micronaut-core/issues/1853#issuecomment-662915261
@Data
@Builder
public class KakaoAccessTokenRequest {

    @FormProperty("grant_type")
    private String grantType;
    @FormProperty("client_id")
    private String clientId;
    @FormProperty("redirect_uri")
    private String redirectUri;
    private String code;
}
