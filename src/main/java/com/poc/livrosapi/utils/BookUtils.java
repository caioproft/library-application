package com.poc.livrosapi.utils;

import com.poc.livrosapi.entities.Book;
import com.poc.livrosapi.entities.request.BookUpdateRequest;
import com.poc.livrosapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookUtils {

    @Autowired
    BookRepository bookRepository;

    public boolean checkBookExistis(BookUpdateRequest bookUpdateRequest){
        Book existsBook = bookRepository.findByName(bookUpdateRequest.getName());
        if(existsBook == null){
            return false;
        }
        else {
            return true;
        }
    }
}
