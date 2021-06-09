package by.example.ClientServer.view.window;

import by.example.ClientServer.client.Client;
import by.example.ClientServer.controller.handler.Handler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveWindow extends Application {
    private final Handler handler;

    public SaveWindow(){
        handler = new Handler(Client.in, Client.out);
        try {
            start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage){
        TextField fileName = new TextField();
        fileName.setPromptText("Имя файла");
        fileName.setMaxWidth(200);

        Button save = new Button("Сохранить");
        save.setOnAction(actionEvent -> {
            handler.saveFile(fileName.getText());
            stage.close();
        });

        VBox rootNode = new VBox(20, fileName, save);
        rootNode.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(rootNode, 300, 150));
        stage.setTitle("Сохранить");
        stage.showAndWait();
    }
}
