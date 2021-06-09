package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.TableParametersResponse;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.server.ServerThread;

public class TableParametersHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        TableController.tuneTableParameters(server.getTableParameters(), server.getRepository().getStudentList().size());
        return new TableParametersResponse(server.getTableParameters());
    }
}
