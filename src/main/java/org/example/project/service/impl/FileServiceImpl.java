package org.example.project.service.impl;

import jakarta.servlet.http.Part;
import org.example.project.model.File;
import org.example.project.repository.FileRepository;
import org.example.project.repository.impl.FileRepositoryImpl;
import org.example.project.service.FileService;

public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;

    public FileServiceImpl() {
        this.fileRepository = new FileRepositoryImpl();
    }

    @Override
    public void deleteFile(long id) {
        fileRepository.deleteFileById(id);
    }

    @Override
    public void uploadFile(Part file, String fileName) {
        File newFile = new File();
        newFile.setFileName(fileName);
        newFile.setContent(file);
        newFile.setFileSize(file.getSize());

        fileRepository.uploadFile(newFile);
    }

    @Override
    public File loadFile(long id) {
        return null;
    }
}
