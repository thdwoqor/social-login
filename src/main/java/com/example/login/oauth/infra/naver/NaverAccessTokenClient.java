package com.example.login.oauth.infra.naver;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface NaverAccessTokenClient {

    @GetExchange(
            value = "https://nid.naver.com/oauth2.0/token",
            accept = MediaType.APPLICATION_JSON_VALUE
    )
    NaverAccessTokenResponse getNaverToken(@RequestParam MultiValueMap<String, String> params);
}
