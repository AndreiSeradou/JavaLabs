package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;

public class RemoveStudentBySRequest extends Request {
    private final String surname;
    private final int minWorkingHours;
    private final int maxWorkingHours;

    public RemoveStudentBySRequest(String surname, int minWorkingHours, int maxWorkingHours){
        super(RequestMode.DELETE_STUDENT_BY_SURNAME);
        this.surname = surname;
        this.minWorkingHours = minWorkingHours;
        this.maxWorkingHours = maxWorkingHours;
    }

    public String getSurname() {
        return surname;
    }

    public int getMinWorkingHours() {
        return minWorkingHours;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }
}
