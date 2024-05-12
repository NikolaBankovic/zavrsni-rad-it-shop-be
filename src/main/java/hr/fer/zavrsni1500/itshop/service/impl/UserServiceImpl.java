package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.util.mapper.UserUserDtoMapper;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.UserRepository;
import hr.fer.zavrsni1500.itshop.service.UserService;
import hr.fer.zavrsni1500.itshop.util.validator.AccountValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUserDtoMapper userUserDtoMapper;
    private final AccountValidator accountValidator;

    //Returns list of all users in database
    public List<UserDto> getAllUsers() {
        final List<User> userList = userRepository.findAll();

        return userUserDtoMapper.userListToUserDtoList(userList);
    }

    //Returns user from database by id
    public UserDto getUserById(final Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with ID(%d) doesn't exist!", id)));
        return userUserDtoMapper.userToUserDto(user);
    }


    public void createUser(UserDto userDto) {
        accountValidator.usernameTaken(userDto.username());
        accountValidator.emailExists(userDto.email());

        final User user = userUserDtoMapper.userDtoToUser(userDto);
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
    }

    public void updateUser(Long id, UserDto userDto) {
        final User user = userRepository.findById(id).orElse(null);

    }
}