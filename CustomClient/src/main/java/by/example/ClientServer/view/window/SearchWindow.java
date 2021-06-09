package by.example.ClientServer.view.window;

import by.example.ClientServer.client.Client;
import by.example.ClientServer.controller.handler.Handler;
import by.example.ClientServer.controller.window.SearchWindowController;
import by.example.ClientServer.model.*;
import by.example.ClientServer.view.сomponent.CustomTable;
import by.example.ClientServer.view.сomponent.MenuSearch;
import by.example.ClientServer.view.сomponent.SearchBySurnameOrGroupNumber;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SearchWindow extends Application {
    public final Handler handler;
    private final StudentList searchList;
    private final ComboBox<String> searchMode;
    private final MenuSearch searchMenuPane;
    private final Button searchButton;
    private final CustomTable customTable;

    public SearchWindow(){
        handler = new Handler(Client.in, Client.out);
        searchList = new StudentList();
        searchMode = new ComboBox<>(FXCollections.observableArrayList("Поиск по фамилии или номеру группы",
                "Поиск по фамилии и рабочим часам", "Поиск по номеру группы и рабочим часам"));
        searchMenuPane = new MenuSearch(new SearchBySurnameOrGroupNumber(handler.getGroupNumberList()), 250, 200);
        searchButton = new Button("Поиск");
        customTable = new CustomTable(searchList, 600, 400);

        start(new Stage());
    }

    @Override
    public void start(Stage stage){
        SearchWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(addMenu(), 0,0);
        root.add(customTable, 1, 0);

        stage.setScene(new Scene(root, 1000, 500));
        stage.show();
    }

    private VBox addMenu(){
        searchMode.setValue("Поиск по фамилии или номеру группы");

        VBox vBox = new VBox(10, searchMode, searchMenuPane, searchButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(300, 200);

        return vBox;
    }

    public Handler getHandler() {
        return handler;
    }

    public ComboBox<String> getSearchMode() {
        return searchMode;
    }

    public MenuSearch getSearchMenuPane() {
        return searchMenuPane;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public StudentList getSearchList() {
        return searchList;
    }

    public CustomTable getCustomTable() {
        return customTable;
    }
}
