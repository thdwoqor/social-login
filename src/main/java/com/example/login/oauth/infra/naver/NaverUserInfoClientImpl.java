package com.example.login.oauth.infra.naver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class NaverUserInfoClientImpl {

//    @Bean
//    public NaverUserInfoClient naverUserInfoClient() {
//        WebClient webClient = WebClient.create();
//        HttpServiceProxyFactory build = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
//                .build();
//        return build.createClient(NaverUserInfoClient.class);
//    }

    @Bean
    public NaverUserInfoClient naverUserInfoClient() {
        RestClient restClient = RestClient.create();
        HttpServiceProxyFactory build = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
        return build.createClient(NaverUserInfoClient.class);
    }
}
