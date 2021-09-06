package com.bookdemo.book.services;

import com.bookdemo.book.model.Student;
import com.bookdemo.book.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllBook() {
        return studentRepository.findAll();
    }

    @Override
    public void saveBook(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void deleteBookByid(long id) {
        this.studentRepository.deleteById(id);
    }
}
