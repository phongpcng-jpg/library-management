package com.example.library_management.models.services;

import com.example.library_management.models.dtos.request.BookCreateDTO;
import com.example.library_management.models.dtos.request.BookUpdateStockDTO;
import com.example.library_management.models.dtos.wrapper.PageResponse;
import com.example.library_management.models.entities.Book;

public interface IBookService {

    PageResponse<Book> findPagedBooks(
        int page,
        int size,
        String sortBy,
        String direction
    );

    Book createBook(BookCreateDTO request);

    Book updateBook(Long id, BookUpdateStockDTO dto);

    Book findBookById(Long id);

}
