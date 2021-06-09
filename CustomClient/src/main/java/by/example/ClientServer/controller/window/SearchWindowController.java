package by.example.ClientServer.controller.window;

import by.example.ClientServer.model.Student;
import javafx.scene.control.Alert;
import by.example.ClientServer.view.window.SearchWindow;
import by.example.ClientServer.view.сomponent.SearchByGroupNumberAndWorkingHours;
import by.example.ClientServer.view.сomponent.SearchBySurnameAndWorkingHours;
import by.example.ClientServer.view.сomponent.SearchBySurnameOrGroupNumber;

import java.util.ArrayList;
import java.util.List;

public class SearchWindowController {

    public static void setController(SearchWindow window){
        setSearchModeBox(window);
        setSearchButton(window);
        setControlButtons(window);
    }

    private static void setSearchModeBox(SearchWindow window){
        window.getSearchMode().setOnAction(actionEvent -> {
            switch (window.getSearchMode().getValue()) {
                case "Поиск по фамилии или номеру группы":
                    window.getSearchMenuPane().setCard(new SearchBySurnameOrGroupNumber(window.getHandler().getGroupNumberList()));
                    break;
                case "Поиск по фамилии и рабочим часам":
                    window.getSearchMenuPane().setCard(new SearchBySurnameAndWorkingHours());
                    break;
                case "Поиск по номеру группы и рабочим часам":
                    window.getSearchMenuPane().setCard(new SearchByGroupNumberAndWorkingHours(window.getHandler().getGroupNumberList()));
                    break;
            }
        });
    }

    private static void setSearchButton(SearchWindow window){
        window.getSearchButton().setOnAction(actionEvent -> {
            window.getSearchList().getList().clear();

            List<Student> firstPage = new ArrayList<>();

            switch (window.getSearchMode().getValue()) {
                case "Поиск по фамилии или номеру группы":
                    window.getHandler().searchStudentBySurnameOrGroupNumber(
                            ((SearchBySurnameOrGroupNumber) window.getSearchMenuPane().getCard()).getSurname(),
                            ((SearchBySurnameOrGroupNumber) window.getSearchMenuPane().getCard()).getGroupNumber());
                    firstPage.addAll(window.getHandler().firstSearchPage(window.getCustomTable().getMaxRecordsNum().getValue()));
                    window.getCustomTable().getTableController().updateTable(firstPage);
                    break;
                case "Поиск по фамилии и рабочим часам":
                    window.getHandler().searchStudentBySurname(
                            ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getGroupNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchBySurnameAndWorkingHours) window.getSearchMenuPane().getCard()).getMaxHoursNumber());
                    firstPage.addAll(window.getHandler().firstSearchPage(window.getCustomTable().getMaxRecordsNum().getValue()));
                    window.getCustomTable().getTableController().updateTable(firstPage);
                    break;
                case "Поиск по номеру группы и рабочим часам":
                    window.getHandler().searchStudentByGroupNumber(
                            ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getGroupNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getMinHoursNumber(),
                            ((SearchByGroupNumberAndWorkingHours) window.getSearchMenuPane().getCard()).getMaxHoursNumber());
                    firstPage.addAll(window.getHandler().firstSearchPage(window.getCustomTable().getMaxRecordsNum().getValue()));
                    window.getCustomTable().getTableController().updateTable(firstPage);
                    break;
            }
            if(firstPage.size() == 0) {
                notFoundMessage();
            }
        });
    }

    private static void setControlButtons(SearchWindow window){
        window.getCustomTable().getFirstPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().firstSearchPage(
                            window.getCustomTable().getMaxRecordsNum().getValue()
                    )
            );
        });
        window.getCustomTable().getLastPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().lastSearchPage(
                            window.getCustomTable().getMaxRecordsNum().getValue()
                    )
            );
        });
        window.getCustomTable().getNextPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().nextSearchPage(
                            window.getCustomTable().getMaxRecordsNum().getValue()
                    )
            );
        });
        window.getCustomTable().getPrevPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().prevSearchPage(
                            window.getCustomTable().getMaxRecordsNum().getValue()
                    )
            );
        });
    }

    private static void notFoundMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Не найдено ни одной подходящей записи");
        alert.show();
    }
}
