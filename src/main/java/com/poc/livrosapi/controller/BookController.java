package com.poc.livrosapi.controller;

import com.poc.livrosapi.entities.Book;
import com.poc.livrosapi.entities.request.BookCreateRequest;
import com.poc.livrosapi.entities.response.BookResponse;
import com.poc.livrosapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> create(@RequestBody BookCreateRequest bookCreateRequest){
        BookResponse bookResponse = bookService.createBook(bookCreateRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> findOne(@PathVariable Long id){
        BookResponse bookResponse = bookService.findOne(id);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookResponse>> findAll(){
        List<BookResponse> bookResponse = bookService.findAll();
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
}
