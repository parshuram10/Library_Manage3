package com.controlleradvice.ControllerAdvice.Controller;

import com.controlleradvice.ControllerAdvice.Model.Book;
import com.controlleradvice.ControllerAdvice.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/saveRecord")
    public ResponseEntity<String> saveRecord(@RequestBody Book book){

        Integer id =bookService.saveBook(book);
        return new  ResponseEntity<String>("Book With "+id+" has been Save",HttpStatus.OK);
    }

    @GetMapping("/bookList")
    public ResponseEntity<List<Book>> getBookList(){

        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Integer id,@RequestBody Book book){

        Book bookFromDb = bookService.getBookById(id);
        bookFromDb.setBookTitle(book.getBookTitle());
        bookFromDb.setBookAuthor(book.getBookAuthor());
        bookFromDb.setPrice(book.getPrice());
        bookService.saveBook(bookFromDb);
        return new ResponseEntity<String>("Book Update "+id+" Updated Success",HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        return new ResponseEntity<String>("Book Delete "+id+" Deleted Success",HttpStatus.OK);
    }
}
