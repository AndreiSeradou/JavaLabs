package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;

import java.util.List;

public class FileNameListResponse extends Response {

    private final List<String> fileNameList;

    public FileNameListResponse(List<String> fileNameList) {
        this.fileNameList = fileNameList;
    }

    public List<String> getFileNameList() {
        return fileNameList;
    }
}
