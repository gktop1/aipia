package com.example.aipia.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public CustomException unknownError() {
        return new CustomException("Unknow Server Error");
    }
}
