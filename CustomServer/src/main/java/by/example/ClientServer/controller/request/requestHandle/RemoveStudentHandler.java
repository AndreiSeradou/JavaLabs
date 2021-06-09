package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.impl.RemoveStudentByGNRequest;
import by.example.ClientServer.controller.request.impl.RemoveStudentBySRequest;
import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.impl.StudentRemoved;
import by.example.ClientServer.model.repository.repositoryServise.RemoveStudent;
import by.example.ClientServer.controller.request.impl.RemoveStudentBySoGNRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class RemoveStudentHandler implements RequestHandler {
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        switch (request.getRequestMode()){
            case DELETE_STUDENT_BY_SURNAME_OR_GROUP_NUMBER:
                return removeBySurnameOrGroupNumber((RemoveStudentBySoGNRequest) request, server);
            case DELETE_STUDENT_BY_SURNAME:
                return removeBySurname((RemoveStudentBySRequest) request, server);
            case DELETE_STUDENT_BY_GROUP_NUMBER:
                return removeByGroupNumber((RemoveStudentByGNRequest) request, server);
            default:
                return null;
        }
    }

    private Response removeBySurnameOrGroupNumber(RemoveStudentBySoGNRequest request, ServerThread server){
        int removedStudentNum = RemoveStudent.removeBySurnameOrGroupNumber(server.getRepository(),
                request.getSurname(), request.getGroupNumber());
        Server.logger.info("Student deleted");
        return new StudentRemoved(removedStudentNum);
    }

    private Response removeBySurname(RemoveStudentBySRequest request, ServerThread server){
        int removedStudentNum = RemoveStudent.removeBySurname(server.getRepository(), request.getSurname(),
                request.getMinWorkingHours(), request.getMaxWorkingHours());
        Server.logger.info("Student deleted");
        return new StudentRemoved(removedStudentNum);
    }

    private Response removeByGroupNumber(RemoveStudentByGNRequest request, ServerThread server){
        int removedStudentNum = RemoveStudent.removeByGroupNumber(server.getRepository(), request.getGroupNumber(),
                request.getMinWorkingHours(), request.getMaxWorkingHours());
        Server.logger.info("Student deleted");
        return new StudentRemoved(removedStudentNum);
    }
}
