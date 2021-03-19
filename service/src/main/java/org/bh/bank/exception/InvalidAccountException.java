package org.bh.bank.exception;

public class InvalidAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAccountException(String message) {
        super(message);
    }
}
