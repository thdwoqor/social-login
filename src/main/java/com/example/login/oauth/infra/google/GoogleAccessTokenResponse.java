package com.example.login.oauth.infra.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GoogleAccessTokenResponse {

    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("expires_in")
    Integer expiresIn;
    String scope;
    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("id_token")
    String idToken;
}
