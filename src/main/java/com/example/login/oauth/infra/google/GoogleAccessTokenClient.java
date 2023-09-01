package com.example.login.oauth.infra.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url="https://oauth2.googleapis.com", value = "GoogleAuthApi")
public interface GoogleAccessTokenClient {

    @PostMapping(
            value = "/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    GoogleAccessTokenResponse getGoogleToken(
            GoogleAccessTokenRequest request
    );
}
