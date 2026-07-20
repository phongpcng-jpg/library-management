package com.example.library_management.models.dtos.response;

import java.time.Instant;

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
public class ErrorResponse<T> {
    
    private Integer status;
    
    private T message;

    @Builder.Default
    private Instant timestamp = Instant.now();

}
