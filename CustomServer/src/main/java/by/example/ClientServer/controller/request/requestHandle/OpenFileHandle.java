package by.example.ClientServer.controller.request.requestHandle;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.OpenFileRequest;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.table.TableController;
import by.example.ClientServer.server.Server;
import by.example.ClientServer.server.ServerThread;
import by.example.ClientServer.xmlParser.SAXmlReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class OpenFileHandle implements RequestHandler{
    @Override
    public Response executeRequest(Request request, ServerThread server) {
        server.getRepository().getStudentList().clear();
        try {
            server.getRepository().getStudentList().addAll(
                    (new SAXmlReader()).openFile(((OpenFileRequest) request).getFileName()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        TableController.tuneTableParameters(server.getTableParameters(), server.getRepository().getStudentList().size());
        Server.logger.info("Open file");
        return null;
    }
}
