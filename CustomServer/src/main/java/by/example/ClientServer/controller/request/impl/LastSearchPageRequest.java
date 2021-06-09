package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class LastSearchPageRequest extends Request {

    private final int maxRecordsNum;

    public LastSearchPageRequest(int maxRecordsNum) {
        super(RequestMode.LAST_SEARCH_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
