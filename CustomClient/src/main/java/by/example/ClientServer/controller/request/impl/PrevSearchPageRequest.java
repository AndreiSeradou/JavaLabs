package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class PrevSearchPageRequest extends Request {

    private final int maxRecordsNum;

    public PrevSearchPageRequest(int maxRecordsNum) {
        super(RequestMode.PREV_SEARCH_PAGE);
        this.maxRecordsNum = maxRecordsNum;
    }

    public int getMaxRecordsNum() {
        return maxRecordsNum;
    }
}
