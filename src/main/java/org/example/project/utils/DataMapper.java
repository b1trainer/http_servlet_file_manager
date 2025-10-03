package org.example.project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataMapper {

    private DataMapper() {
    }

    private static ObjectMapper instance;

    public static ObjectMapper getInstance() {
        if (instance == null) {
            instance = new ObjectMapper();
        }

        return instance;
    }
}
