package com.liberty.services;

import com.liberty.models.Book;
import com.liberty.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 12:41
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
