package com.example.login.oauth.infra.dto;


public record OAuthCodeStateDTO(
        String code,
        String state
) {
}
