package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.PasswordChangeDto;
import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UpdateUserDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.exception.PasswordComplexityException;
import hr.fer.zavrsni1500.itshop.exception.SamePasswordException;
import hr.fer.zavrsni1500.itshop.exception.WrongPasswordException;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.UserRepository;
import hr.fer.zavrsni1500.itshop.service.UserService;
import hr.fer.zavrsni1500.itshop.util.mapper.UserMapper;
import hr.fer.zavrsni1500.itshop.util.validator.AccountValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AccountValidator accountValidator;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        final List<User> userList = userRepository.findAll();

        return userMapper.userListToUserDtoList(userList);
    }

    public UserDto getUserById(final Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID(%d) doesn't exist!", id)));
        return userMapper.userToUserDto(user);
    }


    public void createUser(RegisterDto registerDto) {
        accountValidator.usernameTaken(registerDto.username());
        accountValidator.emailExists(registerDto.email());

        final User user = userMapper.registerDtoToUser(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.password()));

        userRepository.save(user);
    }

    public void updateUser(Long id, UpdateUserDto updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID(%d) doesn't exist!", id)));

        if (!user.getUsername().equals(updatedUser.username())) {
            accountValidator.usernameTaken(updatedUser.username());
        }
        if (!user.getEmail().equals(updatedUser.email())) {
            accountValidator.emailExists(updatedUser.email());
        }

        user.setUsername(updatedUser.username());
        user.setEmail(updatedUser.email());
        user.setPhoneNumber(updatedUser.phoneNumber());
        user.setRole(updatedUser.role());

        userRepository.save(user);
    }

    public void changeUserPassword(Long userId, PasswordChangeDto changePasswordDto) throws WrongPasswordException, PasswordComplexityException, SamePasswordException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID(%d) doesn't exist!", userId)));
        if (!passwordEncoder.matches(changePasswordDto.oldPassword(), user.getPassword())) {
            throw new WrongPasswordException("Old password is incorrect");
        }
        accountValidator.passwordChangeValid(userId, changePasswordDto.newPassword());
        user.setPassword(passwordEncoder.encode(changePasswordDto.newPassword()));
        userRepository.save(user);
    }

    public void deleteUser(final Long userId) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID(%d) doesn't exist!", userId)));
        userRepository.delete(user);
    }
}