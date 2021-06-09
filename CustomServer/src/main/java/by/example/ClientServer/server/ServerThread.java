package by.example.ClientServer.server;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestHandlerProvider;
import by.example.ClientServer.controller.request.requestHandle.RequestHandler;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.table.TableParameters;
import by.example.ClientServer.model.Student;
import by.example.ClientServer.model.repository.Repository;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{
    private final Socket socket;
    private final Repository repository;
    private final List<Student> searchList;
    private final TableParameters tableParameters;
    private final TableParameters searchTableParameters;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private final RequestHandlerProvider provider;

    public ServerThread(Socket socket, Repository repository) throws IOException {
        this.socket = socket;
        this.repository = repository;
        searchList = new ArrayList<>();
        tableParameters = new TableParameters();
        searchTableParameters = new TableParameters();
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        provider = new RequestHandlerProvider();
        start();
    }
    @Override
    public void run() {
        try {
            while (true) {
                Request request = (Request) in.readObject();
                RequestHandler requestHandler = provider.getRequestHandler(request.getRequestMode());
                Response response = requestHandler.executeRequest(request, this);

                out.writeObject(response);
                out.flush();
            }
        } catch (IOException | ClassNotFoundException exception) {
            Server.logger.info("Client disconnected");
            this.interrupt();
        }
    }

    public Repository getRepository() {
        return repository;
    }

    public List<Student> getSearchList() {
        return searchList;
    }

    public TableParameters getTableParameters() {
        return tableParameters;
    }

    public TableParameters getSearchTableParameters() {
        return searchTableParameters;
    }

    public Socket getSocket() {
        return socket;
    }
}
