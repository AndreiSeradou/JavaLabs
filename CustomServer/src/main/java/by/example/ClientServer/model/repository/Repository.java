package by.example.ClientServer.model.repository;

import by.example.ClientServer.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final List<Student> studentList;

    public Repository() {
        studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
