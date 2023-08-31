package com.example.login.auth.google;

import lombok.Data;

@Data
public class GoogleAccessTokenResponse {
    String access_token;
    Integer expires_in;
    String scope;
    String token_type;
    String id_token;
}
