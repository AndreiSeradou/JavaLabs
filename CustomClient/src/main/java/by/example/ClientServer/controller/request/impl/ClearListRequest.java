package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class ClearListRequest extends Request {

    public ClearListRequest() {
        super(RequestMode.CLEAR_LIST);
    }
}
