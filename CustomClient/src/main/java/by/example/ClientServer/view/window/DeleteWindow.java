package by.example.ClientServer.view.window;

import by.example.ClientServer.client.Client;
import by.example.ClientServer.controller.handler.Handler;
import by.example.ClientServer.controller.window.DeleteWindowController;
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

public class DeleteWindow extends Application {
    private final Handler handler;
    private final ComboBox<String> deleteMode;
    private final MenuSearch deleteMenuPane;
    private final Button deleteButton;


    public DeleteWindow(Client client){
        handler = new Handler(Client.in, Client.out);
        deleteMode = new ComboBox<>(FXCollections.observableArrayList("Удаление по фамилии или номеру группы",
                "Удаление по фамилии и рабочим часам", "Удаление по номеру группы и рабочим часам"));
        deleteMenuPane = new MenuSearch(new SearchBySurnameOrGroupNumber(handler.getGroupNumberList()), 250, 200);
        deleteButton = new Button("Удалить");
        start(new Stage());
    }

    @Override
    public void start(Stage stage){
        DeleteWindowController.setController(this);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(addMenu(), 0, 0);
        root.add(deleteMenuPane, 1, 0);

        stage.setScene(new Scene(root, 600, 200));
        stage.showAndWait();
    }

    private VBox addMenu(){
        deleteMode.setValue("Удаление по фамилии или номеру группы");

        VBox vBox = new VBox(10, deleteMode, deleteButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinSize(300, 200);

        return vBox;
    }

    public Handler getHandler() {
        return handler;
    }

    public ComboBox<String> getDeleteMode() {
        return deleteMode;
    }

    public MenuSearch getDeleteMenuPane() {
        return deleteMenuPane;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
