package com.safeway.login.api.controller;

import com.safeway.login.api.dto.TranscationRequest;
import com.safeway.login.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/login-service")
public class WebTokenController {
    @Autowired
    private TokenService tokenService;

    @PostMapping("/accessToken")
    public Mono<String> getAccessToken(@RequestBody TranscationRequest request) {
        return tokenService.generateAccessToken(request);
    }
}
