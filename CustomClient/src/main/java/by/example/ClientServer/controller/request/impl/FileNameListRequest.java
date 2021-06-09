package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class FileNameListRequest extends Request {
    public FileNameListRequest() {
        super(RequestMode.FILE_NAME_LIST);
    }
}
