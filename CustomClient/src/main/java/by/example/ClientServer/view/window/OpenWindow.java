package by.example.ClientServer.view.window;

import by.example.ClientServer.client.Client;
import by.example.ClientServer.controller.handler.Handler;
import by.example.ClientServer.view.сomponent.GroupComboBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpenWindow extends Application {
    private final Handler handler;

    public OpenWindow(){
        handler = new Handler(Client.in, Client.out);
        try {
            start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage){
        GroupComboBox fileNameList = new GroupComboBox(handler.getFileNameList());
        fileNameList.setValue("Имя файла");

        Button open = new Button("Открыть");
        open.setOnAction(actionEvent -> {
            handler.openFile(fileNameList.getValue());
            stage.close();
        });

        VBox rootNode = new VBox(20, fileNameList, open);
        rootNode.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(rootNode, 300, 150));
        stage.setTitle("Открыть");
        stage.showAndWait();
    }
}
