package com.epam.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/test.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar test.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
