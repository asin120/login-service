package com.safeway.login.api.service;

import com.safeway.login.api.dto.TranscationRequest;
import com.safeway.login.api.exception.LoginException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TokenService {

    @Value("${safeway.login.baseURL}")
    private String baseURL;


    public Mono<String> generateAccessToken(TranscationRequest transcationRequest) {
        return buildWebClient().post()
                .uri(baseURL)
                .body(Mono.just(transcationRequest), TranscationRequest.class)
                .retrieve().onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new LoginException("Unable to login into portal"))
                )
                .bodyToMono(String.class);

    }


    private WebClient buildWebClient() {
        return WebClient.builder()
                .baseUrl(baseURL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }
}
