package com.poc.livrosapi.services;

import com.poc.livrosapi.entities.Book;
import com.poc.livrosapi.entities.request.BookCreateRequest;
import com.poc.livrosapi.entities.request.BookUpdateRequest;
import com.poc.livrosapi.entities.response.BookResponse;
import com.poc.livrosapi.exceptions.book.BookConflict;
import com.poc.livrosapi.exceptions.book.BookNotFound;
import com.poc.livrosapi.mapper.BookMapper;
import com.poc.livrosapi.repositories.BookRepository;
import com.poc.livrosapi.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookUtils bookUtils;

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

    public List<BookResponse> findAll(){
        List<Book> bookList = bookRepository.findAll();
        List<BookResponse> bookResponse = new ArrayList<>();
        for(Book book : bookList){
            bookResponse.add(bookMapper.bookToBookResponse(book));
        }

        return bookResponse;
    }

    public void delete(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFound("Livro não encontrado."));
        bookRepository.delete(book);
    }

    public BookResponse update(BookUpdateRequest bookUpdateRequest, Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFound("Livro não encontrado"));

        if(bookUtils.checkBookExistis(bookUpdateRequest)){
            throw new BookConflict("Já existe um livro cadastrado com esse nome.");
        }

        bookMapper.bookUpdateToBook(book, bookUpdateRequest);
        bookRepository.save(book);
        BookResponse bookResponse = bookMapper.bookToBookResponse(book);

        return bookResponse;
    }
}

