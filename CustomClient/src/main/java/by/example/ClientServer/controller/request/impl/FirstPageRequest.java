package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class FirstPageRequest extends Request {

    private final int maxRecordsNum;

    public FirstPageRequest(int maxRecordsNum) {
        super(RequestMode.FIRST_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
