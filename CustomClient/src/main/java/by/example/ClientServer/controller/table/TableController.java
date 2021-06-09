package by.example.ClientServer.controller.table;

import javafx.collections.ObservableList;
import by.example.ClientServer.model.Student;
import by.example.ClientServer.view.сomponent.CustomTable;
import javafx.scene.control.Label;

import java.util.List;

public class TableController {
    private final ObservableList<Student> visibleList;
    private final Label currentPageValue;
    private final Label allRecordsNum;
    private final Label allPageNum;

    public TableController(CustomTable customTable){
        this.visibleList = customTable.getPage();
        currentPageValue = customTable.getCurrentPageValue();
        allPageNum = customTable.getAllPageNum();
        allRecordsNum = customTable.getAllRecordsNum();
    }

    public void updateTable(List<Student> page){
        visibleList.clear();
        visibleList.addAll(page);
    }

    public void updateTableParameters(TableParameters parameters){
        currentPageValue.setText("Страница : " + parameters.getCurrentPageValue());
        allRecordsNum.setText("Число всех записей : " + parameters.getAllRecordsNum());
        allPageNum.setText("Число всех страниц : " + parameters.getAllPageNum());
    }
}
