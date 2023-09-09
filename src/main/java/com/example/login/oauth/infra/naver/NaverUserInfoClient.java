package com.example.login.oauth.infra.naver;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

public interface NaverUserInfoClient {

    @GetExchange(value = "https://openapi.naver.com/v1/nid/me", accept = MediaType.APPLICATION_JSON_VALUE)
    NaverUserInfoResponse getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);
}
