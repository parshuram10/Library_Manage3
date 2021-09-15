package com.example.restapi.services;

import com.example.restapi.Model.Book;

import java.util.List;

public interface BookService {

    Integer saveBook(Book book);

    List<Book> getAllBook();

    Book getBookById(Integer id);

    void deleteBookId(Integer id);
}
