package org.example.project.repository;

import org.example.project.model.File;

public interface FileRepository {
    File getFileById(long id);

    void deleteFileById(long id);

    void uploadFile(File file);
}
