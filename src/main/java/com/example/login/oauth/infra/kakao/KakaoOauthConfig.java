package com.example.login.oauth.infra.kakao;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "oauth.kakao")
public class KakaoOauthConfig {

    private String clientId;
    private String redirectUri;
    private String grantType;
    private String providerName;
}
