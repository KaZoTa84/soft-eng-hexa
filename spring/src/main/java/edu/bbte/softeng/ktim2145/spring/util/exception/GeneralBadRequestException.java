package edu.bbte.softeng.ktim2145.spring.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralBadRequestException extends RuntimeException {
    public GeneralBadRequestException() {
        super();
    }

    public GeneralBadRequestException(String message) {
        super(message);
    }

    public GeneralBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralBadRequestException(Throwable cause) {
        super(cause);
    }
}
