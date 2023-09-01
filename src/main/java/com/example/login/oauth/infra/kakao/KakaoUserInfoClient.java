package com.example.login.oauth.infra.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://kapi.kakao.com", value = "kakaoUserInfoApi")
public interface KakaoUserInfoClient {

    @GetMapping(
            value = "/v2/user/me",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    KakaoUserInfoResponse getUserInfo(@RequestHeader("Authorization") String accessToken);
}
