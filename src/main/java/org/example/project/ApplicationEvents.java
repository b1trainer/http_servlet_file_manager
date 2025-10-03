package org.example.project;

public enum ApplicationEvents {
    FILE_UPLOAD("Загрузка файла"),
    FILE_DOWNLOAD("Скачивание файла"),
    FILE_DELETE("Удаление файла"),

    USER_CREATE("Создание пользователя"),
    USER_DELETE("Удаление пользователя");

    private String description;

    ApplicationEvents(String description) {
        this.description = description;
    }
}
