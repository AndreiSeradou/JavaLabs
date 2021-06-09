package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class FirstSearchPageRequest extends Request {

    private final int maxRecordsNum;

    public FirstSearchPageRequest(int maxRecordsNum) {
        super(RequestMode.FIRST_SEARCH_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
