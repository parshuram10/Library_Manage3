package com.bookdemo.book.services;

import com.bookdemo.book.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllBook();
    void saveBook(Student student);
    void deleteBookByid(long id);
}
