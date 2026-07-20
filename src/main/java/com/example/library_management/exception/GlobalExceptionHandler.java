package com.example.library_management.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.library_management.message.CommonMessage;
import com.example.library_management.models.dtos.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<String>> handleException(
            Exception ex
    ) {

        return ResponseEntity.internalServerError()
                .body(
                    ErrorResponse.<String>builder()
                            .status(500)
                            .message(CommonMessage.EXCEPTION_HANDLE)
                            .build()
                );

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleNotFound(
            ResourceNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                    ErrorResponse.<String>builder()
                            .status(404)
                            .message(ex.getMessage())
                            .build()
                );

    }

    @ExceptionHandler(UploadCloudinaryException.class)
    public ResponseEntity<ErrorResponse<String>> handleUploadCloudinaryFail(
        UploadCloudinaryException ex
    ) {

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body(
                    ErrorResponse.<String>builder()
                            .status(502)
                            .message(ex.getMessage())
                            .build()
                );

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> errorDetailMap = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            if (error instanceof FieldError fieldError) {
                String fieldName = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();

                if (fieldError.getCode() != null && fieldError.getCode().equals("typeMismatch")) {
                    errorDetailMap.put(fieldName, CommonMessage.DATA_STRUCTURE_EXCEPTION);
                } else {
                    errorDetailMap.put(fieldName, defaultMessage);
                }
            } else {
                errorDetailMap.put(error.getObjectName(), error.getDefaultMessage());
            }
        });

        return ResponseEntity.badRequest()
                .body(
                    ErrorResponse.<Map<String, String>>builder()
                            .status(400)
                            .message(errorDetailMap)
                            .build()
                );
    }

}
