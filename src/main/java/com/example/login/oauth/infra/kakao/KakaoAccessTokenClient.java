package com.example.login.oauth.infra.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

//https://github.com/OpenFeign/feign/issues/1927
//https://github.com/spring-projects/spring-framework/issues/18012
@FeignClient(url = "https://kauth.kakao.com", value = "kakaoAuthApi")
public interface KakaoAccessTokenClient {

    @PostMapping(
            value = "/oauth/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    KakaoAccessTokenResponse getKakaoToken(
            KakaoAccessTokenRequest request
    );
}
