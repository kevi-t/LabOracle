package com.project.lab;

import com.project.lab.database.DatabaseConnector;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class BookDao {
    private final DatabaseConnector databaseConnector;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";

        try (Connection connection = databaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Long bookId = resultSet.getLong("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                float price = resultSet.getFloat("price");
                Date publicationDate = resultSet.getDate("publication_date");

                Book book = new Book();
                book.setBookId(bookId);
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setPrice(price);
                book.setPublicationDate(publicationDate);

                books.add(book);
            }
        }
        catch (SQLException e) {
            log.error("An error occurred while fetching books: {}", e.getMessage(), e);
        }
        return books;
    }
}