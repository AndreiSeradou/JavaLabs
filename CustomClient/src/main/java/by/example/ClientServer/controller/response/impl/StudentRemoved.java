package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;

public class StudentRemoved extends Response {
    private final int removedStudentNum;

    public StudentRemoved(int removedStudentNum) {
        this.removedStudentNum = removedStudentNum;
    }

    public int getRemovedStudentNum() {
        return removedStudentNum;
    }
}
