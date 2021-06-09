package by.example.ClientServer.xmlParser;

import by.example.ClientServer.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class DOMxmlWriter {
    public static void saveDocument(String fileName, List<Student> studentList) throws ParserConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(addDocument(studentList));

        File file = new File("C://Users//Lenovo//Desktop//server//CustomServer//src//main//resources//base", fileName);

        StreamResult streamFile = new StreamResult(file);

        transformer.transform(source, streamFile);
    }

    private static Document addDocument(List<Student> studentList) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.appendChild(getRootElement(document, studentList));

        return document;
    }

    private static Element getRootElement(Document document, List<Student> studentList){
        Element rootElement = document.createElement("StudentsList");

        for (Student student : studentList
        ) {
            rootElement.appendChild(getStudent(document, student.getFirstName(),
                    student.getSurname(), student.getSecondName(), student.getGroupNumber(), student.getSocialWork()));
        }

        return rootElement;
    }

    private static Node getStudent(Document doc, String firstName, String surname,
                                   String secondName, String groupNumber, int[] socialWork) {
        Element student = doc.createElement("Student");

        for (int i = 0; i < 10; i++) {
            student.appendChild(getStudentElement(doc, "semester" + i, String.valueOf(socialWork[i])));
        }

        student.appendChild(getStudentElement(doc, "surname", surname));
        student.appendChild(getStudentElement(doc, "firstName", firstName));
        student.appendChild(getStudentElement(doc, "secondName", secondName));
        student.appendChild(getStudentElement(doc, "groupNumber", groupNumber));

        return student;
    }

    private static Node getStudentElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
