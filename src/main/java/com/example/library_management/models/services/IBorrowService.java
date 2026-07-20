package com.example.library_management.models.services;

import com.example.library_management.models.dtos.request.BorrowCreateDTO;
import com.example.library_management.models.entities.Borrow;

public interface IBorrowService {

    Borrow create(BorrowCreateDTO dto);

}
