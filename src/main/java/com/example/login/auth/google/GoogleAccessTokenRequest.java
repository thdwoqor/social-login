package com.example.login.auth.google;

import feign.form.FormProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoogleAccessTokenRequest {

    @FormProperty("client_id")
    String clientId;
    @FormProperty("client_secret")
    String clientSecret;
    String code;
    @FormProperty("redirect_uri")
    String redirectUri;
    @FormProperty("grant_type")
    String grantType;
}
