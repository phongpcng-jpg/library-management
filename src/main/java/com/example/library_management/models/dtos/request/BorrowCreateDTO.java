package com.example.library_management.models.dtos.request;

import com.example.library_management.utils.validations.annotations.ExistingBookId;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowCreateDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;

    @ExistingBookId
    private Integer bookId;
}
