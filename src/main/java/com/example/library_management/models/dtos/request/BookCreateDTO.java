package com.example.library_management.models.dtos.request;

import org.springframework.web.multipart.MultipartFile;

import com.example.library_management.message.BookMessage;
import com.example.library_management.utils.validations.annotations.FileExtension;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateDTO {
    
    @NotBlank(message = BookMessage.TITLE_NOT_BLANK)
    private String title;
    
    @NotBlank(message = BookMessage.AUTHOR_NOT_BLANK)
    private String author;
    
    @PositiveOrZero(message = BookMessage.STOCK_POSITIVE)
    @Builder.Default
    private Integer stock = 0;

    @FileExtension(
        allowedExtensions = {".jpg",".png",".jpeg"},
        message = BookMessage.COVER_IMAGE_EXTENSION
    )
    private MultipartFile coverImage;

}
