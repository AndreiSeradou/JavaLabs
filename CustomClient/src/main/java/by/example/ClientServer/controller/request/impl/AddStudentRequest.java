package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;
import by.example.ClientServer.model.Student;

import java.io.Serializable;

public class AddStudentRequest extends Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Student student;

    public AddStudentRequest(Student student) {
        super(RequestMode.ADD_STUDENT);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
