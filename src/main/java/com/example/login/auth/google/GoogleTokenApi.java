package com.example.login.auth.google;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="https://oauth2.googleapis.com", value = "GoogleAuthApi")
public interface GoogleTokenApi {

    @PostMapping(
            value = "/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    GoogleAccessTokenResponse getGoogleToken(
            GoogleAccessTokenRequest request
    );
}
