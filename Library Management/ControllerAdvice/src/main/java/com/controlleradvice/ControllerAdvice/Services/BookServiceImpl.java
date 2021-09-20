package com.controlleradvice.ControllerAdvice.Services;

import com.controlleradvice.ControllerAdvice.CustomException.InputException;
import com.controlleradvice.ControllerAdvice.CustomException.NotFoundException;
import com.controlleradvice.ControllerAdvice.CustomException.NullCustomException;
import com.controlleradvice.ControllerAdvice.Model.Book;
import com.controlleradvice.ControllerAdvice.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Integer saveBook(Book book) {

        if(book.getBookTitle().isEmpty() || book.getBookTitle().length()==0){
            throw new InputException("601","Book Title Provide Empty Plases check.");
        }
        if(book.getBookAuthor().isEmpty() || book.getBookAuthor().length()==0){
            throw new InputException("601","Book Author Provide Empty Plases check.");
        }
        if(book.getPrice().isEmpty() || book.getPrice().length()==0){
            throw new InputException("601","Book Price Provide Empty Plases check.");
        }
        return bookRepository.save(book).getId();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book>bookList =(List<Book>) bookRepository.findAll();
        if (bookList.isEmpty()){
            throw new NullCustomException("404","Book List Is Empty.");
        }
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {

        if(bookRepository.findById(id).isEmpty()){
            throw new NotFoundException("404","Id You assign not Found");
        }
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteBookId(Integer id) {

        if(bookRepository.findById(id).isEmpty()){
            throw new NotFoundException("404","You specify Id Is Not Found");
        }
        bookRepository.deleteById(id);
    }

}
