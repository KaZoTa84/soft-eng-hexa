package edu.bbte.softeng.ktim2145.spring.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RepositoryException extends RuntimeException {
    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
