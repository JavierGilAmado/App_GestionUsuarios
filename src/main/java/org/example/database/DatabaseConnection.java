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
        URL = System.getenv("DB_URL");
        USER = System.getenv("DB_USER");
        PASSWORD = System.getenv("DB_PASSWORD");

        if (URL == null || USER == null || PASSWORD == null) {
            throw new RuntimeException("Faltan variables de entorno para la base de datos");
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
