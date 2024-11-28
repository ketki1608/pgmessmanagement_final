package com.app.pgmessmanagement.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

   private String message;
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message=message;
    }

}
