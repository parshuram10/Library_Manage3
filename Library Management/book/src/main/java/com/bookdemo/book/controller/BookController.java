package com.bookdemo.book.controller;

import com.bookdemo.book.model.Book;
import com.bookdemo.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //display list of books
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listbooks",bookService.getAllBook());
        return "index";
    }

    @GetMapping("/showSearchBookForm")
    public String showSearchBookForm(Model model,String keyword){
        if(keyword!=null) {
            model.addAttribute("listbooks", bookService.findByKeyword(keyword));
        }else{
            model.addAttribute("listbooks",bookService.getAllBook());
        }
        return "search_book";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        //Create model attribute to bind form data
        Book book = new Book();
        model.addAttribute("book",book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        //save book to database
        bookService.saveEmployee(book);
        return "redirect:/";
    }

    @GetMapping("/showUpdateBookForm/{id}")
    public String showUpdateBookForm(@PathVariable(value = "id") long id, Model model){
        //getBook from the Service
        Book book = bookService.getBookByID(id);
        //set book as model attribute to populate form
        model.addAttribute("book",book);
        return "update_book";
    }

    @GetMapping("/showDeleteBookForm/{id}")
    public String showDeleteBookForm(@PathVariable(value = "id") long id){
        //delete book method
        this.bookService.deleteBookByID(id);
        return "redirect:/";
    }
}
