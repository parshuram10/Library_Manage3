package com.bookdemo.book.repository;

import com.bookdemo.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "select * from bookdetails b where b.book_name like %:keyword%",nativeQuery = true)
    List<Book> findByKeyword(@Param("keyword") String keyword);
}
