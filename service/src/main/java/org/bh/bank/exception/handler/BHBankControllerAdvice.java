package org.bh.bank.exception.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.swagger.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.bh.bank.exception.InvalidAccountException;
import org.bh.bank.exception.InvalidCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

/**
 * The type BH Bank controller advice for exceptions
 */
@Slf4j
@ControllerAdvice
@Component
public class BHBankControllerAdvice {

    /**
     * Handle api error.
     *
     * @param exception the exception
     * @return the api error
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handle(InvalidCustomerException exception) {
        log.error(exception.getMessage(), exception);
        return new ApiError().message(exception.getMessage());
    }

    /**
     * Handle api error.
     *
     * @param exception the exception
     * @return the api error
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handle(InvalidAccountException exception) {
        log.error(exception.getCause().getMessage(), exception.getCause());
        return new ApiError().message(exception.getCause().getMessage());
    }

    /**
     * Handle api error.
     *
     * @param exception the exception
     * @return the api error
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handle(BindException exception) {
        String errors = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(", "));
        log.error(errors);
        return new ApiError().message("Invalid "+errors);
    }

    /**
     * Handle api error.
     *
     * @param exception the exception
     * @return the api error
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handle(InvalidFormatException exception) {
        log.error(exception.getMessage());
        return new ApiError().message(exception.getMessage());
    }
}
