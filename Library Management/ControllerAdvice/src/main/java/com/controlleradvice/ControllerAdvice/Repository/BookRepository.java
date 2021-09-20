package com.controlleradvice.ControllerAdvice.Repository;

import com.controlleradvice.ControllerAdvice.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
}
