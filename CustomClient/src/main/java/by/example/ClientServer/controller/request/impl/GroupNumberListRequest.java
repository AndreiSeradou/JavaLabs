package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class GroupNumberListRequest extends Request {
    public GroupNumberListRequest() {
        super(RequestMode.GROUP_NUMBER_LIST);
    }
}

