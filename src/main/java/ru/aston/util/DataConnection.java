package ru.aston.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataConnection {

    public Connection getConnection() {
        try {
            Properties properties = loadProperties();
            Class.forName(properties.getProperty("driver"));

            return DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException("Ошибка при получении соединения с базой данных", e);
        }
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл database.properties не найден");
            }
            properties.load(input);
        }
        return properties;
    }
}
