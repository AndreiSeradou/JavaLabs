package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.NextPageRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.RefreshTablePage;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.controller.table.TablePage;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class NextPageHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        TableController.tuneMaxRecordsNum(server.getTableParameters(), ((NextPageRequest) request).getMaxRecordsNum());
        TableController.incrementPage(server.getTableParameters());
        TableController.tuneTableParameters(server.getTableParameters(), server.getRepository().getStudentList().size());
        Server.logger.info("Next page on");
        return new RefreshTablePage(TablePage.getPage(server.getRepository().getStudentList(), server.getTableParameters()));
    }
}
