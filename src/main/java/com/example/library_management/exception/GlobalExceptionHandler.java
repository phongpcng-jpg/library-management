package com.example.library_management.exception;

import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(
            ResourceNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.fail(ex.getMessage()));

    }

    @ExceptionHandler(UploadCloudinaryException.class)
    public ResponseEntity<ApiResponse<Void>> handleUploadCloudinaryFail(
        UploadCloudinaryException ex
    ) {

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body(ApiResponse.fail(ex.getMessage()));

    }

}
