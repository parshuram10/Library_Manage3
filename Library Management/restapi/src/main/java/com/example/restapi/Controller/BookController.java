package com.example.restapi.Controller;

import com.example.restapi.Model.Book;
import com.example.restapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restApi")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@RequestBody Book book){

        Integer id = bookService.saveBook(book);
        return new ResponseEntity<String>("Book With"+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBook(){
        List<Book> bookList =bookService.getAllBook();
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
        bookFromDb.setBookName(book.getBookName());
        bookFromDb.setBookAuthor(book.getBookAuthor());
        bookFromDb.setPrice(book.getPrice());
        bookService.saveBook(bookFromDb);
        return new ResponseEntity<String>("Book With "+id+" Has been Updated.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBookId(id);
        return new ResponseEntity<String>("Book With "+id+" Has been deleted.", HttpStatus.OK);
    }
}
