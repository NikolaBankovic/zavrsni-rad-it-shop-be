package hr.fer.zavrsni1500.itshop.exception;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message) {
        super(message);
    }
}
