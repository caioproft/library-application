package com.poc.livrosapi.entities.response;

import com.poc.livrosapi.mapper.BookMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BookResponse {

    private Long id;
    private String name;
    private int pageNumber;
    private LocalDateTime createdAt;

}
