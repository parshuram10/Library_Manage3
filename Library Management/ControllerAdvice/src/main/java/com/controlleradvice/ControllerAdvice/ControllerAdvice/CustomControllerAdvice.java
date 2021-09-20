package com.controlleradvice.ControllerAdvice.ControllerAdvice;

import com.controlleradvice.ControllerAdvice.CustomException.InputException;
import com.controlleradvice.ControllerAdvice.CustomException.NotFoundException;
import com.controlleradvice.ControllerAdvice.CustomException.NullCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(InputException.class)
    public ResponseEntity<String> getInputError(InputException inputException){
        return new ResponseEntity<String>(inputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullCustomException.class)
    public ResponseEntity<String> getNullError(NullCustomException nullCustomException){
        return new ResponseEntity<String>(nullCustomException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> getNotError(NotFoundException notFoundException){
        return new ResponseEntity<String>(notFoundException.getErrorMessage(),HttpStatus.NOT_FOUND);
    }

}
