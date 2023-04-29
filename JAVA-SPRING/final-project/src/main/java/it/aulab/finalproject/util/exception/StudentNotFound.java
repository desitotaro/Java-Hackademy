package it.aulab.finalproject.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Lesson not found!")
public class StudentNotFound extends RuntimeException{
    
}
