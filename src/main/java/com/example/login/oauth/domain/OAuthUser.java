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
    private String oauthId;
    private String email;
    private String nickname;

    public OAuthUser(final String oauthId, final String email, final String nickname) {
        this.oauthId = oauthId;
        this.email = email;
        this.nickname = nickname;
    }
}
