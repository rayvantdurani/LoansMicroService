package com.loans.Exception;

import com.loans.LoansDTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleRuntimeException(Exception exception, WebRequest
                                            webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
                , LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LoanIdNotFound.class)
    public ResponseEntity<ErrorResponseDTO> LoanIdNotFound(LoanIdNotFound exception, WebRequest
            webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage()
                , LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanAlreadyExists.class)
    public ResponseEntity<ErrorResponseDTO> LoanAlreadyExists(LoanAlreadyExists exception, WebRequest
            webRequest)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage()
                , LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
