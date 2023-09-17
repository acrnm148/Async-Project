package com.async.myapp.async.web.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoMoreThread extends RuntimeException {
    private String message;

    public NoMoreThread(String message) {
        super(message);
        this.message = message;
    }
}
