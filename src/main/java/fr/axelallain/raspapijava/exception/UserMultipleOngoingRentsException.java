package fr.axelallain.raspapijava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserMultipleOngoingRentsException extends RuntimeException {

    public UserMultipleOngoingRentsException(String s) {
        super(s);
    }
}
