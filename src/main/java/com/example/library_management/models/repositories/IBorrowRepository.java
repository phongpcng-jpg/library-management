package com.example.library_management.models.repositories;

import com.example.library_management.models.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
}
