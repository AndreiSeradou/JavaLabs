package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.LastPageRequest;
import by.example.ClientServer.controller.request.impl.LastSearchPageRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.RefreshTablePage;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.controller.table.TablePage;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class LastSearchPageHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        TableController.tuneMaxRecordsNum(server.getSearchTableParameters(), ((LastSearchPageRequest) request).getMaxRecordsNum());
        TableController.tuneTableParameters(server.getSearchTableParameters(), server.getSearchList().size());
        TableController.turnLastPage(server.getSearchTableParameters());
        Server.logger.info("Last page on");
        return new RefreshTablePage(TablePage.getPage(server.getSearchList(), server.getSearchTableParameters()));
    }
}
