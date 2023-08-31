package com.example.login;

import com.example.login.auth.google.GoogleAccessTokenResponse;
import com.example.login.auth.google.GoogleUserInfoResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final GoogleLoginServiceImpl googleLoginServiceImpl;
    private final SocialUserRepository socialUserRepository;

    public Long doGoogleLogin(String code) {
        GoogleAccessTokenResponse response = googleLoginServiceImpl.getAccessToken(code);
        GoogleUserInfoResponse userInfo = googleLoginServiceImpl.getUserInfo(response.getAccess_token());

        Optional<SocialUser> findSocialUser = socialUserRepository.findByProvideId(Long.valueOf(userInfo.getId()));

        if (findSocialUser.isEmpty()) {
            socialUserRepository.save(userInfo.toSocialUser());
        }

        return userInfo.toSocialUser().getProvideId();
    }
}
