package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.impl.AddStudentRequest;
import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.model.repository.repositoryServise.AddStudent;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;

public class AddStudentHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        AddStudent.addStudent(server.getRepository(), ((AddStudentRequest)request).getStudent());
        Server.logger.info("Student added");
        return null;
    }
}
