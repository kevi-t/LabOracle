package com.project.lab;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}