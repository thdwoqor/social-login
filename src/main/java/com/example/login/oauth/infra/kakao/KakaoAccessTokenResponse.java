package com.example.login.oauth.infra.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoAccessTokenResponse {

    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("refresh_token")
    String refreshToken;
    @JsonProperty("expires_in")
    Integer expiresIn;
    String scope;
    @JsonProperty("refresh_token_expires_in")
    Integer refreshTokenExpiresIn;
}
