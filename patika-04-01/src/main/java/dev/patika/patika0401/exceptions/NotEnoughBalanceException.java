package dev.patika.patika0401.exceptions;

public class NotEnoughBalanceException extends RuntimeException {
    public NotEnoughBalanceException(String s) {
        super(s);
    }
}
