package by.example.ClientServer.model.repository.repositoryServise;

import by.example.ClientServer.model.repository.Repository;
import by.example.ClientServer.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SearchStudent {
    public static List<Student> searchBySurnameOrGroupNumber(Repository repository, String surname, String groupNumber){
        List<Student> newStudentList = new ArrayList<>();
        for (var student : repository.getStudentList()
             ) {
            if(student.getSurname().equals(surname) || student.getGroupNumber().equals(groupNumber))
                newStudentList.add(student);
        }
        return newStudentList;
    }

    public static List<Student> searchBySurname(Repository repository, String surname, int minWorkingHours, int maxWorkingHours){
        List<Student> newStudentList = new ArrayList<>();
        for (var student : repository.getStudentList()
        ) {
            if(student.getSurname().equals(surname) &&
            minWorkingHours < student.getWorkingHours() &&
            student.getWorkingHours() < maxWorkingHours)
                newStudentList.add(student);
        }
        return newStudentList;
    }

    public static List<Student> searchByGroupNumber(Repository repository, String groupNumber, int minWorkingHours, int maxWorkingHours){
        List<Student> newStudentList = new ArrayList<>();
        for (var student : repository.getStudentList()
        ) {
            if(student.getGroupNumber().equals(groupNumber) &&
                    minWorkingHours < student.getWorkingHours() &&
                    student.getWorkingHours() < maxWorkingHours)
                newStudentList.add(student);
        }
        return newStudentList;
    }
}
