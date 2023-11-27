package com.springbootjpalombok.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

@ControllerAdvice
public class ResExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ErrorMessage> handleError2(HttpServletRequest req, Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                ex.getCause().getLocalizedMessage());
        if (ex.getCause().getCause() instanceof SQLException) {
            SQLException e = (SQLException) ex.getCause().getCause();
            errorMessage.setErrorMessage(e.getLocalizedMessage());
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<ErrorMessage> handleConstraintException(ConstraintViolationException ex) {
        // Handle the exception and return an appropriate response
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                ex.getCause().getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ DataException.class })
    public ResponseEntity<ErrorMessage> handleNotFoundException(DataException ex) {
        // Handle the exception and return an appropriate response
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorMessage> handleNotFoundException(Exception ex) {
        // Handle the exception and return an appropriate response
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Add more exception handlers as needed

}
