package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class NextPageRequest extends Request {

    private final int maxRecordsNum;

    public NextPageRequest(int maxRecordsNum) {
        super(RequestMode.NEXT_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}