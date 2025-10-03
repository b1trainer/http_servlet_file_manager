package org.example.project.model;

import jakarta.servlet.http.Part;

public class File {
    private long fileId;
    private String fileName;
    private Long fileSize;
    private Part content;

    public File() {
    }

    public File(long fileId, String fileName, Long fileSize, Part content) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.content = content;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Part getContent() {
        return content;
    }

    public void setContent(Part content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
