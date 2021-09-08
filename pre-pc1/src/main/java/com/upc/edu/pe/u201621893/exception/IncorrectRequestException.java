package com.upc.edu.pe.u201621893.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException(String message){
        super(message);
    }
}