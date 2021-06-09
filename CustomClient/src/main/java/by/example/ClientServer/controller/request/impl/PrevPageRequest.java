package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class PrevPageRequest extends Request {

    private final int maxRecordsNum;

    public PrevPageRequest(int maxRecordsNum) {
        super(RequestMode.PREV_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
