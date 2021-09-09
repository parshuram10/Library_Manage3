package com.example.postman.service;

import com.example.postman.entity.Book;

import java.util.List;

public interface BookService {

    public Integer saveBook(Book book);
    public List<Book> getAllBook();
    public Book getStudentById(Integer id);
    public void deleteBook(Integer id);

}
