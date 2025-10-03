package org.example.project.service;

import jakarta.servlet.http.Part;
import org.example.project.model.File;

public interface FileService {

    void deleteFile(long id);

    void uploadFile(Part file, String fileName);

    File loadFile(long id);
}
