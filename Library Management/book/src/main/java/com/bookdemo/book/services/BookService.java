package com.bookdemo.book.services;

import com.bookdemo.book.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();
    void saveEmployee(Book book);
    List<Book> getBook(String keyword);
    Book getBookByID(long id);
    void deleteBookByID(long id);

}
