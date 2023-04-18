package it.aulab.springbootcontroller.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AuthorBadRequest extends RuntimeException {
    public AuthorBadRequest() {
    }
    public AuthorBadRequest(String message) {
        super(message);
    }
}

