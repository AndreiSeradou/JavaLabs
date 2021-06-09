package by.example.ClientServer.controller.window;

import javafx.scene.control.Alert;
import by.example.ClientServer.view.window.DeleteWindow;
import by.example.ClientServer.view.сomponent.SearchByGroupNumberAndWorkingHours;
import by.example.ClientServer.view.сomponent.SearchBySurnameAndWorkingHours;
import by.example.ClientServer.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.stage.Stage;

public class DeleteWindowController {

    public static void setController(DeleteWindow window) {
        setDeleteModeBox(window);
        setDeleteButton(window);
    }

    private static void setDeleteModeBox(DeleteWindow window) {
        window.getDeleteMode().setOnAction(actionEvent -> {
            switch (window.getDeleteMode().getValue()) {
                case "Удаление по фамилии или номеру группы":
                    window.getDeleteMenuPane().setCard(new SearchBySurnameOrGroupNumber(window.getHandler().getGroupNumberList()));
                    break;
                case "Удаление по фамилии и рабочим часам":
                    window.getDeleteMenuPane().setCard(new SearchBySurnameAndWorkingHours());
                    break;
                case "Удаление по номеру группы и рабочим часам":
                    window.getDeleteMenuPane().setCard(new SearchByGroupNumberAndWorkingHours(window.getHandler().getGroupNumberList()));
                    break;
            }
        });
    }

    private static void setDeleteButton(DeleteWindow window) {
        window.getDeleteButton().setOnAction(actionEvent -> {
            int remoteStudentsNum;
            switch (window.getDeleteMode().getValue()) {
                case "Удаление по фамилии или номеру группы":
                    remoteStudentsNum = window.getHandler().removeStudentBySurnameOrGroupNumber(
                            ((SearchBySurnameOrGroupNumber) window.getDeleteMenuPane().getCard()).getSurname(),
                            ((SearchBySurnameOrGroupNumber) window.getDeleteMenuPane().getCard()).getGroupNumber());
                    break;
                case "Удаление по фамилии и рабочим часам":
                    remoteStudentsNum = window.getHandler().removedStudentBySurname(
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getGroupNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getDeleteMenuPane().getCard()).getMaxHoursNumber());
                    break;
                case "Удаление по номеру группы и рабочим часам":
                    remoteStudentsNum = window.getHandler().removedStudentByGroupNumber(
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getGroupNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getDeleteMenuPane().getCard()).getMaxHoursNumber());
                    break;
                default:
                    remoteStudentsNum = 0;
            }
            displayMessage(remoteStudentsNum);
            ((Stage) window.getDeleteButton().getScene().getWindow()).close();
        });
    }

    private static void displayMessage(int remoteStudentsNum) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Некорректный ввод данных!");
        if (remoteStudentsNum == 0) {
            alert.setContentText("Не найдено ни одной подходящей записи");
        } else {
            alert.setContentText("Удалено записей : " + remoteStudentsNum);
        }
        alert.show();
    }
}
