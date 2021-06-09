package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.FileNameListResponse;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileNameListHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        File dir = new File("C://Users//Lenovo//Desktop//server//CustomServer//src//main//resources//base");
        List<String> fileNameList = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.list())));
        Server.logger.info("Get file name list");
        return new FileNameListResponse(fileNameList);
    }
}
