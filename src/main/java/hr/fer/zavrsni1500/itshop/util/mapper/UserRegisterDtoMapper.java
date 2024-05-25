package hr.fer.zavrsni1500.itshop.util.mapper;

import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegisterDtoMapper {
    UserDto userToRegisterDto(User user);
    User registerDtoToUser(RegisterDto registerDto);
}
