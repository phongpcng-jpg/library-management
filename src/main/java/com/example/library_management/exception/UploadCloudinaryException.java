package com.example.library_management.exception;

import lombok.Getter;

@Getter
public class UploadCloudinaryException extends RuntimeException {

    public UploadCloudinaryException(String message) {
        super(message);
    }

}
