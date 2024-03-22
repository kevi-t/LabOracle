package com.project.lab;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private Long bookId;
    private String title;
    private String author;
    private String genre;
    private float price;
    private Date publicationDate;
}