package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class SearchStudentBySoNGRequest extends Request {
    private final String surname;
    private final String groupNumber;

    public SearchStudentBySoNGRequest(String surname, String groupNumber) {
        super(RequestMode.SEARCH_STUDENT_BY_SURNAME_OR_GROUP_NUMBER);
        this.surname = surname;
        this.groupNumber = groupNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroupNumber() {
        return groupNumber;
    }
}
