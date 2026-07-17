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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(
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
                .body(ApiResponse.fail(
                    CommonMessage.DATA_BINDING_EXCEPTION,
                    errorDetailMap
                ));
    }

}
