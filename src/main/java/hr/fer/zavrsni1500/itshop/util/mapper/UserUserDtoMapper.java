package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserUserDtoMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> userListToUserDtoList(List<User> userList);
    List<User> userDtoListToUserList(List<UserDto> userDtoList);
}
