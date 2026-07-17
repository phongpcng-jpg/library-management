package com.example.library_management.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.models.entities.Book;

public interface IBookRepository 
    extends JpaRepository<Book, Long>{

}
