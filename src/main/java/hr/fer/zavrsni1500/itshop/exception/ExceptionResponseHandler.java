package hr.fer.zavrsni1500.itshop.exception;

import hr.fer.zavrsni1500.itshop.dto.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(final EntityNotFoundException e) {
        final ErrorResponse body = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WrongPasswordException.class})
    public ResponseEntity<ErrorResponse> handleWrongPasswordException(final WrongPasswordException e) {
        final ErrorResponse body = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({SamePasswordException.class})
    public ResponseEntity<ErrorResponse> handleSamePasswordException(final SamePasswordException e) {
        final ErrorResponse body = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PasswordComplexityException.class})
    public ResponseEntity<ErrorResponse> handlePasswordComplexityException(final PasswordComplexityException e) {
        final ErrorResponse body = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<ErrorResponse> handleInvalidTokenException(final InvalidTokenException e) {
        final ErrorResponse body = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

}
