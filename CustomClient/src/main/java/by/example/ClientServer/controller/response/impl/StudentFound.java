package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.model.Student;

import java.util.List;

public class StudentFound extends Response {
    private final List<Student> foundStudentList;

    public StudentFound(List<Student> foundStudentList) {
        this.foundStudentList = foundStudentList;
    }

    public List<Student> getFoundStudentList() {
        return foundStudentList;
    }
}
