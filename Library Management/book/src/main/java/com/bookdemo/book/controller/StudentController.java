package com.bookdemo.book.controller;

import com.bookdemo.book.model.Book;
import com.bookdemo.book.model.Student;
import com.bookdemo.book.services.BookService;
import com.bookdemo.book.services.StudentService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookController bookController;

    @GetMapping("/issuedBookForm")
    public String issuedBook(Model model){
        model.addAttribute("listissued",studentService.getAllBook());
        return "issued_book";
    }

    @GetMapping("/showReturnBookForm/{id}")
    public String showReturnBookForm(@PathVariable(value = "id") long id){
        this.studentService.deleteBookByid(id);
        return "issued_book";
    }
    @GetMapping("/showUpdateIssuedForm/{id}")
    public String showUpdateBookForm(@PathVariable(value = "id") long id, Model model){
        //getBook from the Service
        Book book = bookService.getBookByID(id);
        //set book as model attribute to populate form
        model.addAttribute("book",book);
        return "new_issued";
    }

    @PostMapping("/saveIssuedBook")
    public String saveIssuedBook(@ModelAttribute("student") Student student){
        studentService.saveBook(student);
        return "redirect:issuedBookForm";
    }

    @GetMapping("/goHome")
    public String goHome(){
        return "redirect:/";
    }
}
