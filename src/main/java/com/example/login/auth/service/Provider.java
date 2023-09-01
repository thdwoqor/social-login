package com.example.login.auth.service;

public enum Provider {

    KAKAO,
    GOOGLE;

    public static Provider from(final String providerName) {
        try {
            return Provider.valueOf(providerName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 Provider Name 입니다.");
        }
    }
}
