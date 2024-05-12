package hr.fer.zavrsni1500.itshop.exception;

public class SamePasswordException extends Exception{
    public SamePasswordException(String message) {
        super(message);
    }
}
