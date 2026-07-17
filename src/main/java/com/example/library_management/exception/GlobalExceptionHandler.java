package com.example.library_management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.library_management.message.CommonMessage;
import com.example.library_management.models.dtos.wrapper.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            Exception ex
    ) {

        return ResponseEntity.internalServerError()
                .body(ApiResponse.fail(
                    CommonMessage.EXCEPTION_HANDLE
                ));
                
    }

}
