package com.controlleradvice.ControllerAdvice.Services;

import com.controlleradvice.ControllerAdvice.Model.Book;

import java.util.List;

public interface BookService {

    Integer saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Integer id);

    void deleteBookId(Integer id);
}
