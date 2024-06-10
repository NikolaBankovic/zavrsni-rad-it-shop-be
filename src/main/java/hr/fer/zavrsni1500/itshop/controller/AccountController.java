package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.PasswordChangeDto;
import hr.fer.zavrsni1500.itshop.dto.RegisterDto;
import hr.fer.zavrsni1500.itshop.dto.UpdateUserDto;
import hr.fer.zavrsni1500.itshop.dto.UserDto;
import hr.fer.zavrsni1500.itshop.exception.PasswordComplexityException;
import hr.fer.zavrsni1500.itshop.exception.SamePasswordException;
import hr.fer.zavrsni1500.itshop.exception.WrongPasswordException;
import hr.fer.zavrsni1500.itshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    public UserDto getUserById(@PathVariable final Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void createUser(@RequestBody final RegisterDto registerDto) {
        userService.createUser(registerDto);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateUser(@PathVariable final Long userId, @RequestBody final UpdateUserDto userUpdateDto) {
        userService.updateUser(userId, userUpdateDto);
    }

    @PatchMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || @currentUserService.isCurrentUserMakingRequest(#userId)")
    public void changeUserPassword(@PathVariable final Long userId,
                                   @RequestBody final PasswordChangeDto changePasswordDto) throws
            PasswordComplexityException,
            SamePasswordException,
            WrongPasswordException {
        userService.changeUserPassword(userId, changePasswordDto);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable final Long userId) {
        userService.deleteUser(userId);
    }
}
