package by.example.ClientServer.view;

import by.example.ClientServer.controller.window.ServerWindowController;
import by.example.ClientServer.handlerLoger.CustomLogHandler;
import by.example.ClientServer.server.Server;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class ServerWindow extends Application {
    private final Button startServer;
    private final Button stopServer;
    private final TextArea textArea;
    private final Server server;

    public ServerWindow(){
        startServer = new Button("Start");
        stopServer = new Button("Stop");
        textArea = new TextArea();
        textArea.setMaxWidth(580);
        Server.logger = Logger.getLogger(Server.class.getName());
        Server.logger.addAppender(new CustomLogHandler(this));
        server = new Server();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ServerWindowController.setController(this);

        VBox rootNode = new VBox(10);
        rootNode.getChildren().addAll(startServer, stopServer, textArea);
        rootNode.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(rootNode, 600, 300));
        stage.setTitle("Server");
        stage.show();
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getStartServer() {
        return startServer;
    }

    public Button getStopServer() {
        return stopServer;
    }

    public Server getServer() {
        return server;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
