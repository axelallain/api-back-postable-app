package fr.axelallain.raspapijava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LetterboxNotFoundException extends RuntimeException {

    public LetterboxNotFoundException(String s) { super(s); }
}
