package by.example.ClientServer.model.repository.repositoryServise;

import by.example.ClientServer.model.repository.Repository;

public class RemoveStudent {
    public static int removeBySurnameOrGroupNumber(Repository repository, String surname, String groupNumber){
        int deletedStudent = 0;
        for (int i = 0; i < repository.getStudentList().size(); i++){
            if(repository.getStudentList().get(i).getSurname().equals(surname) ||
                    repository.getStudentList().get(i).getGroupNumber().equals(groupNumber)) {
                repository.getStudentList().remove(i--);
                ++deletedStudent;
            }
        }
        return deletedStudent;
    }

    public static int removeBySurname(Repository repository, String surname, int minWorkingHours, int maxWorkingHours){
        int deletedStudent = 0;
        for (int i = 0; i < repository.getStudentList().size(); i++){
            if(repository.getStudentList().get(i).getSurname().equals(surname) &&
                    minWorkingHours <= repository.getStudentList().get(i).getWorkingHours() &&
                    repository.getStudentList().get(i).getWorkingHours() <= maxWorkingHours) {
                repository.getStudentList().remove(i--);
                ++deletedStudent;
            }
        }
        return deletedStudent;
    }

    public static int removeByGroupNumber(Repository repository, String groupNumber, int minWorkingHours, int maxWorkingHours){
        int deletedStudent = 0;
        for (int i = 0; i < repository.getStudentList().size(); i++){
            if(repository.getStudentList().get(i).getGroupNumber().equals(groupNumber) &&
                    minWorkingHours <= repository.getStudentList().get(i).getWorkingHours() &&
                    repository.getStudentList().get(i).getWorkingHours() <= maxWorkingHours) {
                repository.getStudentList().remove(i--);
                ++deletedStudent;
            }
        }
        return deletedStudent;
    }
}
