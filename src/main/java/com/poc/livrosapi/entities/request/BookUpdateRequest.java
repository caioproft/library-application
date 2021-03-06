package com.poc.livrosapi.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    private String name;
    private int pageNumber;
}
