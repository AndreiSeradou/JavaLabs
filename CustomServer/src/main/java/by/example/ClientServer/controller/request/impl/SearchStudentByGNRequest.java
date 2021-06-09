package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class SearchStudentByGNRequest extends Request {
    private final String groupNumber;
    private final int minWorkingHours;
    private final int maxWorkingHours;

    public SearchStudentByGNRequest(String groupNumber, int minWorkingHours, int maxWorkingHours) {
        super(RequestMode.SEARCH_STUDENT_BY_GROUP_NUMBER);
        this.groupNumber = groupNumber;
        this.minWorkingHours = minWorkingHours;
        this.maxWorkingHours = maxWorkingHours;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public int getMinWorkingHours() {
        return minWorkingHours;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }
}
