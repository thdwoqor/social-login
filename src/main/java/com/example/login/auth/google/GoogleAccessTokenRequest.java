package com.example.login.auth.google;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoogleAccessTokenRequest {
    String client_id;
    String client_secret;
    String code;
    String redirect_uri;
    String grant_type;
}
