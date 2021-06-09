package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.server.ServerThread;

public class ClearListHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        server.getSearchList().clear();
        server.getRepository().getStudentList().clear();
        return null;
    }
}
