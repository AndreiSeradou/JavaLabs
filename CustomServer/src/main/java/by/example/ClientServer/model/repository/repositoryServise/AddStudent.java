package by.example.ClientServer.model.repository.repositoryServise;

import by.example.ClientServer.model.repository.Repository;
import by.example.ClientServer.model.Student;

public class AddStudent {
    public static void addStudent(Repository repository, Student student){
        repository.getStudentList().add(student);
    }
}
