package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.FirstSearchPageRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.RefreshTablePage;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.controller.table.TablePage;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class FirstSearchPageHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        TableController.tuneMaxRecordsNum(server.getSearchTableParameters(), ((FirstSearchPageRequest) request).getMaxRecordsNum());
        TableController.tuneTableParameters(server.getSearchTableParameters(), server.getSearchList().size());
        TableController.turnFirstPage(server.getSearchTableParameters());
        Server.logger.info("First page on");
        return new RefreshTablePage(TablePage.getPage(server.getSearchList(), server.getSearchTableParameters()));
    }
}
