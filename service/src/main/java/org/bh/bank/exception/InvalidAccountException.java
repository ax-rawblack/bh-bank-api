package org.bh.bank.exception;

/**
 * The type Invalid account exception.
 */
public class InvalidAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Invalid account exception.
     *
     * @param message the message
     */
    public InvalidAccountException(String message) {
        super(message);
    }
}
