package com.controlleradvice.ControllerAdvice.CustomException;

public class InputException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public InputException(String errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public InputException(){}

    public String getErrorMessage() {
        return errorMessage;
    }
}
