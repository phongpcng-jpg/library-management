package com.example.library_management.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.library_management.models.dtos.request.BorrowCreateDTO;
import com.example.library_management.models.entities.Borrow;
import com.example.library_management.models.services.IBorrowService;

@RestController
@RequestMapping("/api/borrows")
@RequiredArgsConstructor
public class BorrowController {

    private final IBorrowService borrowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Borrow create(@Valid @RequestBody BorrowCreateDTO dto){

        return borrowService.create(dto);
    }
}