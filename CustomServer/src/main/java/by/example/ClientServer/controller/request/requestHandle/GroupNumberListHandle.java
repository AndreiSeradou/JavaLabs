package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.GroupNUmberListResponse;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GroupNumberListHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        Set<String> groupNumbers = new HashSet<>();
        for (var student : server.getRepository().getStudentList()) {
            groupNumbers.add(student.getGroupNumber());
        }
        Server.logger.info("Get group number list");
        return new GroupNUmberListResponse(new ArrayList<>(groupNumbers));
    }
}
