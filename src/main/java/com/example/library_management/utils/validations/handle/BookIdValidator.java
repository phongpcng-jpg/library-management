package com.example.library_management.utils.validations.handle;

import com.example.library_management.models.repositories.IBookRepository;
import com.example.library_management.utils.validations.annotations.ExistingBookId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long> {

    private final IBookRepository bookRepository;

    @Override
    public boolean isValid(Long value,
                           ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return bookRepository.existsById(value);
    }
}
