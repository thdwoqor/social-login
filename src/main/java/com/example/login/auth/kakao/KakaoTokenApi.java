package com.example.login.auth.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//https://github.com/OpenFeign/feign/issues/1927
@FeignClient(url = "https://kauth.kakao.com", value = "kakaoAuthApi")
public interface KakaoTokenApi {

    @PostMapping(
            value = "/oauth/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    KakaoAccessTokenResponse getKakaoToken(
            @RequestBody KakaoAccessTokenRequest request
    );
}
