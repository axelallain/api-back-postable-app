package fr.axelallain.raspapijava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class RentDurationException extends RuntimeException {

    public RentDurationException(String s) { super(s); }
}
