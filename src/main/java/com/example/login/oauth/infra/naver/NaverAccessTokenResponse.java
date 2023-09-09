package com.example.login.oauth.infra.naver;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(value = SnakeCaseStrategy.class)
public class NaverAccessTokenResponse {

    String accessToken;
    String refreshToken;
    String tokenType;
    Integer expiresIn;
    String error;
    String errorDescription;
}
