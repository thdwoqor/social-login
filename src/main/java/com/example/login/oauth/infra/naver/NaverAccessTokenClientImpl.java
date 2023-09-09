package com.example.login.oauth.infra.naver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class NaverAccessTokenClientImpl {

    @Bean
    public NaverAccessTokenClient naverApiClient() {
        WebClient webClient = WebClient.create();
        HttpServiceProxyFactory build = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build();
        return build.createClient(NaverAccessTokenClient.class);
    }
}
