package com.oauth.resourceserver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
	Map<String, String> hello(@AuthenticationPrincipal Jwt jwt) {
//    Map<String, String> hello() {
		return Map.of("message", "Hello " + jwt.getSubject());
//        return Map.of("message", "Hello ");
    }
}
