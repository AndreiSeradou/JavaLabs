package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class UpdatePageRequest extends Request {

    private final int maxRecordsNum;

    public UpdatePageRequest(int maxRecordsNum) {
        super(RequestMode.UPDATE_TABLE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
