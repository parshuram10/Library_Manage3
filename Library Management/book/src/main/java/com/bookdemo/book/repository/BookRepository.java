package com.bookdemo.book.repository;

import com.bookdemo.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "select * from bookdetails where book_name LIKE %?1%",nativeQuery = true)
    public List<Book> search(@Param("keyword") String keyword);
}
