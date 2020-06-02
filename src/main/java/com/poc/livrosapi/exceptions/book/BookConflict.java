package com.poc.livrosapi.exceptions.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookConflict extends RuntimeException {

    public BookConflict(String message){
        super(message);
    }
}
