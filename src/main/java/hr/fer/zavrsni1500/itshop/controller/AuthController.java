package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.model.Role;
import hr.fer.zavrsni1500.itshop.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenProvider tokenProvider;

    @GetMapping("/login")
    public String login() {
        final String token = tokenProvider.generateToken("tova", Role.ROLE_ADMIN);
        return token;
    }
}
