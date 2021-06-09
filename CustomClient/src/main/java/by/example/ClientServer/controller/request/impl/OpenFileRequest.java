package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class OpenFileRequest extends Request {

    private final String fileName;

    public OpenFileRequest(String fileName) {
        super(RequestMode.OPEN_FILE);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
