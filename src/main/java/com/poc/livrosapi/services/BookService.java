package com.poc.livrosapi.services;

import com.poc.livrosapi.entities.Book;
import com.poc.livrosapi.entities.request.BookCreateRequest;
import com.poc.livrosapi.entities.response.BookResponse;
import com.poc.livrosapi.expections.book.BookNotFound;
import com.poc.livrosapi.mapper.BookMapper;
import com.poc.livrosapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private BookMapper bookMapper;

    public BookResponse createBook(BookCreateRequest bookCreateRequest){

        Book book = bookMapper.bookRequestToBook(bookCreateRequest);
        bookRepository.save(book);
        BookResponse bookResponse = bookMapper.bookToBookResponse(book);
        return bookResponse;
    }

    public BookResponse findOne(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFound("Livro não encontrado"));
        BookResponse bookResponse = bookMapper.bookToBookResponse(book);

        return bookResponse;
    }
}
