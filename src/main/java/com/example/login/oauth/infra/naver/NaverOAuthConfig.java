package com.example.login.oauth.infra.naver;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "oauth.naver")
public class NaverOAuthConfig {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String grantType;
    private String providerName;
}
