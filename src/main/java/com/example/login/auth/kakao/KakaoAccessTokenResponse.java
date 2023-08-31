package com.example.login.auth.kakao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KakaoAccessTokenResponse {
    String access_token;
    String token_type;
    String refresh_token;
    Integer expires_in;
    String scope;
    Integer refresh_token_expires_in;
}
