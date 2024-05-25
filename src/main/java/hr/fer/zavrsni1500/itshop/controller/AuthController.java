package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.LoginDto;
import hr.fer.zavrsni1500.itshop.dto.LoginResponse;
import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/current")
    public UserDto getCurrentUser() {
        return authService.getCurrentUser();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody final LoginDto user) {
        return authService.login(user);
    }

    @PostMapping("/register")
    public void register(@RequestBody final RegisterDto user) {
        authService.register(user);
    }
}
