package com.yodegree.yodegree_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    public  ResourceNotFoundException(){
        super("Resource not found");
    }

    public  ResourceNotFoundException(String message){
        super(message, null);
    }

    public  ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
