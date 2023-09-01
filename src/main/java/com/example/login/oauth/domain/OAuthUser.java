package com.example.login.oauth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class OAuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provideId;
    private String email;
    private String nickname;

    public OAuthUser(final String provideId, final String email, final String nickname) {
        this.provideId = provideId;
        this.email = email;
        this.nickname = nickname;
    }
}
