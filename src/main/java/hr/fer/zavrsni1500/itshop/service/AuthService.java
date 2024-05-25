package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.LoginDto;
import hr.fer.zavrsni1500.itshop.dto.LoginResponse;
import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.model.User;

public interface AuthService {
    UserDto getCurrentUser();

    LoginResponse login(LoginDto loginDto);

    void register(RegisterDto registerDto);

}
