package com.project.lab.database;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnector {
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConnector(DatabaseConfiguration databaseConfiguration) {
        this.url = databaseConfiguration.getUrl();
        this.username = databaseConfiguration.getUsername();
        this.password = databaseConfiguration.getPassword();
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}