package com.controlleradvice.ControllerAdvice.CustomException;

public class NotFoundException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public NotFoundException(String errorCode,String errorMessage){

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public NotFoundException(){}

    public String getErrorMessage() {
        return errorMessage;
    }
}
