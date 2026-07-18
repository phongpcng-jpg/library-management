package com.example.library_management.controller;

import com.example.library_management.models.dtos.request.BookUpdateStockDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library_management.message.BookMessage;
import com.example.library_management.models.dtos.request.BookCreateDTO;
import com.example.library_management.models.dtos.wrapper.ApiResponse;
import com.example.library_management.models.dtos.wrapper.PageResponse;
import com.example.library_management.models.entities.Book;
import com.example.library_management.models.services.IBookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> createBook(
        @Valid @ModelAttribute BookCreateDTO request
    ) {

        Book response = bookService.createBook(request);

        return ResponseEntity.ok(
            ApiResponse.success(
                BookMessage.CREATED,
                response
            )
        );

    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<Book>>> getPagedBook(
                
        @RequestParam(name = "page", defaultValue = "0")
        int page,

        @RequestParam(name = "size", defaultValue = "10")
        int size,

        @RequestParam(name = "sortBy", required = false)
        String sortBy,

        @RequestParam(name = "direction", required = false)
        String direction

    ) {

        PageResponse<Book> response =
            bookService.findPagedBooks(page, size, sortBy, direction);

        return ResponseEntity.ok(
            ApiResponse.success(
                BookMessage.GET_PAGE,
                response
            )
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(

        @PathVariable Long id,

        @Valid @RequestBody BookUpdateStockDTO request

    ) {

        Book response = bookService.updateBook(
                id, request
        );

        return ResponseEntity.ok(
                ApiResponse.success(
                        BookMessage.UPDATE,
                        response
                )
        );

    }

}
