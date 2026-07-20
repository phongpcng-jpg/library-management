package com.example.library_management.models.services.impl;

import org.springframework.stereotype.Service;

import com.example.library_management.models.dtos.request.BorrowCreateDTO;
import com.example.library_management.models.entities.Borrow;
import com.example.library_management.models.repositories.IBorrowRepository;
import com.example.library_management.models.services.IBorrowService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements IBorrowService{

    private final IBorrowRepository borrowRepository;

    public Borrow create(BorrowCreateDTO dto){

        Borrow borrow = Borrow.builder()
                .username(dto.getUsername())
                .bookId(dto.getBookId())
                .build();

        return borrowRepository.save(borrow);
    }

}
