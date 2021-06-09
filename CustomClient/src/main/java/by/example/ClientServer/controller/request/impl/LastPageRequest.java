package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class LastPageRequest extends Request {

    private final int maxRecordsNum;

    public LastPageRequest(int maxRecordsNum) {
        super(RequestMode.LAST_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
