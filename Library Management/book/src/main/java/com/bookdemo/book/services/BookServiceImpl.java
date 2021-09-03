package com.bookdemo.book.services;

import com.bookdemo.book.model.Book;
import com.bookdemo.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void saveEmployee(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book getBookByID(long id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;

        if(optional.isPresent()){
            book = optional.get();
        }else {
            throw new RuntimeException("Book Not Found for id ::"+id);
        }

        return book;
    }

    @Override
    public void deleteBookByID(long id) {
        this.bookRepository.deleteById(id);
    }
}
