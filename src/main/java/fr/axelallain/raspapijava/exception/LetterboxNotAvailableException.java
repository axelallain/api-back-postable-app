package fr.axelallain.raspapijava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class LetterboxNotAvailableException extends RuntimeException {

    public LetterboxNotAvailableException(String s) {
        super(s);
    }
}
