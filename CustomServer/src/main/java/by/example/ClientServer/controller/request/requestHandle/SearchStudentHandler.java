package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.*;
import by.example.ClientServer.controller.request.impl.SearchStudentByGNRequest;
import by.example.ClientServer.controller.request.impl.SearchStudentBySRequest;
import by.example.ClientServer.controller.request.impl.SearchStudentBySoNGRequest;
import by.example.ClientServer.model.repository.repositoryServise.SearchStudent;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class SearchStudentHandler implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        switch (request.getRequestMode()) {
            case SEARCH_STUDENT_BY_SURNAME_OR_GROUP_NUMBER:
                return searchBySurnameOrGroupNumber((SearchStudentBySoNGRequest) request, server);
            case SEARCH_STUDENT_BY_SURNAME:
                return searchBySurname((SearchStudentBySRequest) request, server);
            case SEARCH_STUDENT_BY_GROUP_NUMBER:
                return searchByGroupNumber((SearchStudentByGNRequest) request, server);
            default:
                return null;
        }
    }

    private Response searchBySurnameOrGroupNumber(SearchStudentBySoNGRequest request, ServerThread server){
        server.getSearchList().clear();
        server.getSearchList().addAll(SearchStudent.searchBySurnameOrGroupNumber(server.getRepository(),
                request.getSurname(), request.getGroupNumber()));
        Server.logger.info("Search student");
        return null;
    }

    private Response searchBySurname(SearchStudentBySRequest request, ServerThread server){
        server.getSearchList().clear();
        server.getSearchList().addAll(SearchStudent.searchBySurname(server.getRepository(), request.getSurname(),
                request.getMinWorkingHours(), request.getMaxWorkingHours()));
        Server.logger.info("Search student");
        return null;
    }

    private Response searchByGroupNumber(SearchStudentByGNRequest request, ServerThread server){
        server.getSearchList().clear();
        SearchStudent.searchBySurnameOrGroupNumber(server.getRepository(),
                request.getGroupNumber(), request.getGroupNumber());
        Server.logger.info("Search student");
        return null;
    }
}
