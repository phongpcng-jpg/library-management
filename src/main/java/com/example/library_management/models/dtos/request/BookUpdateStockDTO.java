package com.example.library_management.models.dtos.request;

import com.example.library_management.message.BookMessage;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookUpdateStockDTO {

    @PositiveOrZero(message = BookMessage.STOCK_POSITIVE)
    @Builder.Default
    private Integer stock = 0;

}
