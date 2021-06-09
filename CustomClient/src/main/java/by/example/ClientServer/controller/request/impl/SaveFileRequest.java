package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class SaveFileRequest extends Request {

    private final String fileName;

    public SaveFileRequest(String fileName) {
        super(RequestMode.SAVE_FILE);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
