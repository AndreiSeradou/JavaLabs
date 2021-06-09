package by.example.ClientServer.view.сomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.model.Student;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import by.example.ClientServer.model.StudentList;


public class CustomTable extends VBox {
    private final ObservableList<Student> page;
    private final TableController tableController;

    private final TableView<Student> table;
    private final Button firstPageButton;
    private final Button lastPageButton;
    private final Button nextPageButton;
    private final Button prevPageButton;
    private final Label currentPageValue;
    private final Label allRecordsNum;
    private final Label allPageNum;
    private final NumberCount maxRecordsNum;

    public CustomTable(StudentList studentList, int width, int height){
        super(10);
        page = FXCollections.observableArrayList();

        table = new TableView<>(page);
        table.setMaxWidth(width);
        table.setMaxHeight(height - 50);

        firstPageButton = new Button("Первая страница");
        lastPageButton = new Button("Последняя страница");
        nextPageButton = new Button("=>");
        prevPageButton = new Button("<=");
        currentPageValue = new Label("Страница : 0");
        allPageNum = new Label("Число всех страниц : 0");
        allRecordsNum = new Label("Число всех записей : 0");
        maxRecordsNum = new NumberCount(10, 120);

        this.setMinSize(width, height);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(table, createControlPane(), createInfoPane());

        setColumns();

        tableController = new TableController(this);
    }

    private HBox createControlPane(){
        HBox hBox = new HBox(10, firstPageButton, prevPageButton, currentPageValue,
                nextPageButton, lastPageButton);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private HBox createInfoPane(){
        HBox hBox = new HBox(10, allPageNum, maxRecordsNum, allRecordsNum);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private void setColumns(){
        TableColumn<Student, String> nameColumn = new TableColumn<>("ФИО");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));

        TableColumn<Student, String> groupNumberColumn = new TableColumn<>("Номер\nгруппы");
        groupNumberColumn.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));

        TableColumn<Student, String> socialWorkColumn = new TableColumn<>("Общественная работа");

        table.getColumns().addAll(nameColumn, groupNumberColumn, socialWorkColumn);

        for(int i = 0; i < 10; i++){
            int finalI = i;
            TableColumn workingHours = new TableColumn<>(i + 1 + " семестр");
            workingHours.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Integer>, ObservableValue<Integer>>() {
                @Override
                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Student, Integer> studentIntegerCellDataFeatures) {
                    return studentIntegerCellDataFeatures.getValue().getSocialWork(finalI);
                }
            });
            socialWorkColumn.getColumns().add(workingHours);
        }
        System.out.println();
    }

    public ObservableList<Student> getPage() {
        return page;
    }

    public Button getFirstPageButton() {
        return firstPageButton;
    }

    public Button getLastPageButton() {
        return lastPageButton;
    }

    public Button getNextPageButton() {
        return nextPageButton;
    }

    public Button getPrevPageButton() {
        return prevPageButton;
    }

    public Label getCurrentPageValue() {
        return currentPageValue;
    }

    public Label getAllRecordsNum() {
        return allRecordsNum;
    }

    public Label getAllPageNum() {
        return allPageNum;
    }

    public NumberCount getMaxRecordsNum() {
        return maxRecordsNum;
    }

    public TableController getTableController() {
        return tableController;
    }
}
