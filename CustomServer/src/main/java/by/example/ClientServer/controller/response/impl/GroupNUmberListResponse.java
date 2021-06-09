package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;

import java.util.List;

public class GroupNUmberListResponse extends Response {
    private final List<String> groupNumberList;

    public GroupNUmberListResponse(List<String> groupNumberList) {
        this.groupNumberList = groupNumberList;
    }

    public List<String> getGroupNumberList() {
        return groupNumberList;
    }
}
