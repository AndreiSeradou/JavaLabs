package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.model.Student;

import java.util.List;

public class RefreshTablePage extends Response {
    private final List<Student> newTablePage;

    public RefreshTablePage(List<Student> page) {
        newTablePage = page;
    }

    public List<Student> getNewTablePage() {
        return newTablePage;
    }
}
