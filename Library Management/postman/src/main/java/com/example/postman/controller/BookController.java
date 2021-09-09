package com.example.postman.controller;

import com.example.postman.entity.Book;
import com.example.postman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/bookDetails")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@RequestBody Book book){

        Integer id = bookService.saveBook(book);
        return new ResponseEntity<String>("Book With"+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/bookList")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        Book bookObj = bookService.getStudentById(id);
        return new ResponseEntity<Book>(bookObj,HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Integer id,@RequestBody Book book){
        Book bookFromDB = bookService.getStudentById(id);
        bookFromDB.setBookName(book.getBookName());
        bookFromDB.setBookAuthor(book.getBookAuthor());
        bookFromDB.setBookPrice(book.getBookPrice());
        bookService.saveBook(bookFromDB);
        return new ResponseEntity<String>("Book with"+id+"has been updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<String>("Book with"+id+"has been deleted",HttpStatus.OK);
    }


}
