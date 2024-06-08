package hr.fer.zavrsni1500.itshop.exception;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(final String message) {
        super(message);
    }
}
