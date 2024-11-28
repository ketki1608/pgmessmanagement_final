package com.app.pgmessmanagement.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceFoundException extends RuntimeException{
    private String message;
    public ResourceFoundException() {
        super();
    }

    public ResourceFoundException(String message) {
        super(message);
        this.message=message;
    }
}
