package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.PasswordChangeDto;
import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UpdateUserDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.exception.PasswordComplexityException;
import hr.fer.zavrsni1500.itshop.exception.SamePasswordException;
import hr.fer.zavrsni1500.itshop.exception.WrongPasswordException;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void createUser(RegisterDto userDto);

    void updateUser(Long id, UpdateUserDto userDto);

    void changeUserPassword(Long userId, PasswordChangeDto passwordChangeDto) throws WrongPasswordException, PasswordComplexityException, SamePasswordException;

    void deleteUser(Long userId);
}
