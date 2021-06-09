package by.example.ClientServer.view.window;

import by.example.ClientServer.client.Client;
import by.example.ClientServer.controller.handler.Handler;
import by.example.ClientServer.controller.window.MainWindowController;
import by.example.ClientServer.model.*;
import by.example.ClientServer.view.сomponent.CustomMenuBar;
import by.example.ClientServer.view.сomponent.CustomTable;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class MainWindow extends Application{
    private final Handler handler;
    private final Button saveButton;
    private final Button openButton;
    private final Button addButton;
    private final Button deleteButton;
    private final Button searchButton;
    private final Button clearButton;
    private final Client client;
    private final CustomTable customTable;
    private final CustomMenuBar menu;

    public MainWindow(){
        saveButton = new Button("Сохранить");
        openButton = new Button("Отрыть");
        addButton = new Button("Добавить");
        deleteButton = new Button("Удалить");
        searchButton = new Button("Найти");
        clearButton = new Button("Очистить");
        client = new Client();
        handler = new Handler(Client.in, Client.out);
        customTable = new CustomTable(new StudentList(), 1028, 500);
        menu = new CustomMenuBar();
    }

    @Override
    public void start(Stage stage){
        MainWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.add(menu, 0, 0, 2, 1);
        root.add(addMenuPanel(), 1, 1);
        root.add(customTable, 0,1);

        stage.setScene(new Scene(root, 1200, 520));
        stage.show();
    }

    private VBox addMenuPanel(){
        Button[] menuButtons = {saveButton, openButton, addButton, deleteButton, searchButton, clearButton};
        for (Button button:menuButtons
             ) {
            button.setMinWidth(80);
        }

        VBox vBox = new VBox(10);
        vBox.setMinSize(120, 350);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(saveButton, openButton, addButton, deleteButton, searchButton, clearButton);
        return new VBox(vBox);
    }

    public CustomTable getCustomTable() {
        return customTable;
    }

    public Handler getHandler() {
        return handler;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getOpenButton() {
        return openButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Client getClient() {
        return client;
    }

    public CustomMenuBar getMenu() {
        return menu;
    }

    public CustomTable getInfoTable() {
        return customTable;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
