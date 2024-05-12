package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.model.User;

public interface CurrentUserService {

    String getCurrentUserUsername();

    User getCurrentUser();

    boolean isCurrentUserAdmin();

    boolean isCurrentUserMakingRequest(final Long id);
}
