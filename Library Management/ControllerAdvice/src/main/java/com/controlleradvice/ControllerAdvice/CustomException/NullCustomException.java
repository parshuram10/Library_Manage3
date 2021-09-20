package com.controlleradvice.ControllerAdvice.CustomException;

public class NullCustomException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public NullCustomException(String errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public NullCustomException(){}

    public String getErrorMessage() {
        return errorMessage;
    }
}
