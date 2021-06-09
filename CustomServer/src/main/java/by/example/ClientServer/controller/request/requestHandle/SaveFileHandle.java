package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.SaveFileRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;
import by.example.ClientServer.xmlParser.DOMxmlWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class SaveFileHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        try {
            DOMxmlWriter.saveDocument(((SaveFileRequest)request).getFileName(), server.getRepository().getStudentList());
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        Server.logger.info("Save file");
        return null;
    }
}
