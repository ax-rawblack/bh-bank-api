package org.bh.bank.exception;

/**
 * The type Invalid customer exception.
 */
public class InvalidCustomerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Invalid customer exception.
     *
     * @param message the message
     */
    public InvalidCustomerException(String message) {
        super(message);
    }
}
