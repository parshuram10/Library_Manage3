package com.example.restapi.services;

import com.example.restapi.Model.Book;
import com.example.restapi.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Integer saveBook(Book book) {

        return bookRepository.save(book).getId();
    }

    @Override
    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteBookId(Integer id) {
        bookRepository.deleteById(id);
    }


}
