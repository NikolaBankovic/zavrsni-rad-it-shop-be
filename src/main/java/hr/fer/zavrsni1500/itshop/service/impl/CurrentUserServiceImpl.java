package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.model.Role;
import hr.fer.zavrsni1500.itshop.model.User;
import hr.fer.zavrsni1500.itshop.repository.UserRepository;
import hr.fer.zavrsni1500.itshop.service.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {

    private final UserRepository userRepository;

    public String getCurrentUserUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public User getCurrentUser() {
        final String currentUserUsername = getCurrentUserUsername();

        return userRepository.findByUsername(currentUserUsername);
    }

    public boolean isCurrentUserAdmin() {
        final User currentUser = getCurrentUser();

        return Role.ROLE_ADMIN.equals(currentUser.getRole());
    }

    public boolean isCurrentUserMakingRequest(final Long id) {
        final User currentUser = getCurrentUser();
        return Objects.equals(currentUser.getId(), id);
    }
}
