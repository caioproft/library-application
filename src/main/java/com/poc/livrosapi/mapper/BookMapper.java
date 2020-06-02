package com.poc.livrosapi.mapper;

import com.poc.livrosapi.entities.Book;
import com.poc.livrosapi.entities.request.BookCreateRequest;
import com.poc.livrosapi.entities.request.BookUpdateRequest;
import com.poc.livrosapi.entities.response.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public Book bookRequestToBook(BookCreateRequest bookCreateRequest){

        Book book = new Book();

        book.setName(bookCreateRequest.getName());
        book.setPageNumber(bookCreateRequest.getPageNumber());

        return book;
    }

    public BookResponse bookToBookResponse(Book book){

        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .pageNumber(book.getPageNumber())
                .createdAt(book.getCreatedAt())
                .build();
    }

    public void bookUpdateToBook(Book book, BookUpdateRequest bookUpdateRequest){
        book.setName(bookUpdateRequest.getName());
        book.setPageNumber(bookUpdateRequest.getPageNumber());
    }
}
