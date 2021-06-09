package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.NextSearchPageRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.RefreshTablePage;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.controller.table.TablePage;
import by.example.ClientServer.server.ServerThread;

public class NextSearchPageHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        TableController.tuneMaxRecordsNum(server.getSearchTableParameters(), ((NextSearchPageRequest) request).getMaxRecordsNum());
        TableController.incrementPage(server.getSearchTableParameters());
        TableController.tuneTableParameters(server.getSearchTableParameters(), server.getSearchList().size());
        return new RefreshTablePage(TablePage.getPage(server.getSearchList(), server.getSearchTableParameters()));
    }
}
