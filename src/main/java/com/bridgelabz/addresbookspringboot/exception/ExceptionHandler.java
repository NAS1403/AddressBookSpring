package com.bridgelabz.addresbookspringboot.exception;


import com.bridgelabz.addresbookspringboot.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleExceptions(CustomException exception){
    ResponseDTO responseDTO = new ResponseDTO("Exception occurred while parsing",exception.getMessage());
    return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

}

