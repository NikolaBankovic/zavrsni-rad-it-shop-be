package hr.fer.zavrsni1500.itshop.mapper;

import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserUserDtoMapper {
    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);
    List<UserDto> UserListToUserDtoList(List<User> userList);
    List<User> UserDtoListToUserList(List<UserDto> userDtoList);
}
