package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class NextSearchPageRequest extends Request {

    private final int maxRecordsNum;

    public NextSearchPageRequest(int maxRecordsNum) {
        super(RequestMode.NEXT_SEARCH_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
