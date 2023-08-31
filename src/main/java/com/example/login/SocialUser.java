package com.example.login;

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
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long provideId;
    private String email;
    private String nickname;

    public SocialUser(final Long provideId, final String email, final String nickname) {
        this.provideId = provideId;
        this.email = email;
        this.nickname = nickname;
    }
}
