package com.yodegree.yodegree_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends  RuntimeException{

    public InvalidCredentialsException(){
        super("Invalid credentials");
    }

    public InvalidCredentialsException(String message){
        super(message, null);
    }

    public InvalidCredentialsException(String message, Throwable cause){
        super(message, cause);
    }
}
