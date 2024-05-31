package hr.fer.zavrsni1500.itshop.exception;

import lombok.Getter;

@Getter
public class InvalidTokenException extends Exception {
    public InvalidTokenException(final String message) {
        super(message);
    }
}
