package com.controlleradvice.ControllerAdvice.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "booklet")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @Column(name = "price")
    private String price;

}
