package com.example.library_management.models.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.library_management.models.dtos.request.BookCreateDTO;
import com.example.library_management.models.dtos.wrapper.PageResponse;
import com.example.library_management.models.entities.Book;
import com.example.library_management.models.repositories.IBookRepository;
import com.example.library_management.models.services.IBookService;
import com.example.library_management.models.services.uploads.UploadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService{

    private final IBookRepository bookRepository;

    private final UploadService uploadService;

    @Override
    public PageResponse<Book> findPagedBooks(int page, int size, String sortBy, String direction) {
        
        if (page < 0) {
            page = 0;
        }

        Sort sort = Sort.unsorted();

        if (
            sortBy != null && !sortBy.isBlank()
            && direction != null && !direction.isBlank()
        ) {

            sort = direction.equalsIgnoreCase("DESC")
                        ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending();

        }

        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<Book> bookPage = 
            bookRepository.findAll(pageable);

        return PageResponse.<Book>builder()
                .items(bookPage.getContent())
                .page(bookPage.getNumber())
                .size(bookPage.getSize())
                .totalItems(bookPage.getTotalElements())
                .totalPages(bookPage.getTotalPages())
                .isLast(bookPage.isEmpty())
                .build();
        
    }

    @Override
    public Book createBook(BookCreateDTO request) {
        
        Book book = Book.builder()
            .id(null)
            .title(request.getTitle())
            .author(request.getAuthor())
            .stock(request.getStock())
            .coverUrl(uploadService.upload(
                request.getCoverImage()
            ))
            .build();
        
        return bookRepository.save(book);

    }

}
