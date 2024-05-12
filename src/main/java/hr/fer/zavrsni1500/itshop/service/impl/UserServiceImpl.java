package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.mapper.UserUserDtoMapper;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.UserRepository;
import hr.fer.zavrsni1500.itshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUserDtoMapper userUserDtoMapper;

    //Returns list of all users in database
    public List<UserDto> getAllUsers() {
        final List<User> userList = userRepository.findAll();

        return userUserDtoMapper.UserListToUserDtoList(userList);
    }
}