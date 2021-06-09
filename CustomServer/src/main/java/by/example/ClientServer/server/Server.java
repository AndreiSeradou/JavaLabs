package by.example.ClientServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import by.example.ClientServer.model.repository.Repository;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Server extends Thread {
    public static Logger logger = Logger.getLogger(Server.class.getName());
    public final Repository repository = new Repository();
    private ServerSocket server;
    private final List<ServerThread> serverList;

    public Server() {
        serverList = new ArrayList<>();
        try {
            server = new ServerSocket(8000);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        logger.info("Start server");
        try {
            while (true) {
                Socket socket = server.accept();
                logger.info("Client connected");
                serverList.add(new ServerThread(socket, repository));
            }
        } catch (IOException ignored) {

        }
    }

    public void closeServer(){
        for(var serverThread : serverList){
            try {
                if(serverThread.getSocket() != null)
                    serverThread.getSocket().close();
                logger.info("Close client");
            } catch (IOException exception) {
                logger.log(Level.FATAL, "Error closing client", exception);
            }
        }

        try {
            if (server !=null)
                server.close();
            logger.info("Server close");
        } catch (IOException exception) {
            logger.log(Level.FATAL, "Error closing server", exception);
        }
    }
}
