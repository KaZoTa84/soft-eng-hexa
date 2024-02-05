package edu.bbte.softeng.ktim2145.spring.adapter.in.web.controlleradvice;

import edu.bbte.softeng.ktim2145.spring.util.exception.GeneralBadRequestException;
import edu.bbte.softeng.ktim2145.spring.util.exception.NotFoundException;
import edu.bbte.softeng.ktim2145.spring.util.exception.RepositoryException;
import edu.bbte.softeng.ktim2145.spring.util.exception.ServiceException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Stream<String> handleConstraintViolation(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream()
                .map(it -> it.getPropertyPath().toString() + " " + it.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Stream<String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .map(it -> it.getField() + " " + it.getDefaultMessage());
    }

    @ExceptionHandler(GeneralBadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final String handleGeneralBadRequest(GeneralBadRequestException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final String handleNotFound(NotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String handleRepository(RepositoryException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String handleService(ServiceException exception) {
        return exception.getMessage();
    }
}
