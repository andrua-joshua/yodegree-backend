package com.yodegree.yodegree_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException  extends  RuntimeException{

    public  UnauthorizedException(){
        super("Unauthorized");
    }

    public  UnauthorizedException(String message){
        super(message, null);
    }

    public  UnauthorizedException(String message, Throwable cause){
        super(message, cause);
    }



}
