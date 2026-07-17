package com.example.library_management.utils.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.library_management.utils.validations.handle.FileExtensionValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = FileExtensionValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileExtension {

    String message() default "Invalid file extension";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

    String[] allowedExtensions() default {".jpg",".png",".jpeg"};

}