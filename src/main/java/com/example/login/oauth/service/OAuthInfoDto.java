package com.example.login.oauth.service;

import lombok.Builder;

@Builder
public record OAuthInfoDto(
        String code,
        String state,
        String provider
) {
}
