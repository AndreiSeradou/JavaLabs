package by.example.ClientServer.controller.window;

import by.example.ClientServer.view.ServerWindow;

public class ServerWindowController {
    public static void setController(ServerWindow window){
        window.getStartServer().setOnAction(actionEvent -> window.getServer().start());
        window.getStopServer().setOnAction(actionEvent -> {
            window.getServer().closeServer();
            window.getServer().interrupt();
        });
    }
}
