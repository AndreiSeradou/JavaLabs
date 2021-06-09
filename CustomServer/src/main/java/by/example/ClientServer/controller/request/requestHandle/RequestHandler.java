package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.server.ServerThread;

public interface RequestHandler {
    public Response executeRequest(Request request, ServerThread server);
}
