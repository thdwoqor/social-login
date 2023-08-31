package com.example.login.auth.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://www.googleapis.com/", value = "googleUserApi")
public interface GoogleUserApi {

    @GetMapping("/userinfo/v2/me")
    GoogleUserInfoResponse getUserInfo(@RequestParam("access_token") String accessToken);
}
