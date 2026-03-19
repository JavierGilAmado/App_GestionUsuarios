package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConnection {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try {
            Properties props = new Properties();
            props.load(DatabaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties"));

            URL = System.getenv("DB_URL");
            USER = System.getenv("DB_USER");
            PASSWORD = System.getenv("DB_PASSWORD");

            // Fallback a properties si no hay ENV
            if (URL == null) URL = props.getProperty("db.url");
            if (USER == null) USER = props.getProperty("db.user");
            if (PASSWORD == null) PASSWORD = props.getProperty("db.password");

            // Último fallback (por si todo falla)
            if (URL == null) URL = "jdbc:mysql://localhost:3306/user_management";
            if (USER == null) USER = "root";
            if (PASSWORD == null) PASSWORD = "root123";

        } catch (IOException e) {
            throw new RuntimeException("Error cargando configuración", e);
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
