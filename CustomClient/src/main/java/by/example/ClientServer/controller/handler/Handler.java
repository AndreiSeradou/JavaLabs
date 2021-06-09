package by.example.ClientServer.controller.handler;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.impl.*;
import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.*;
import by.example.ClientServer.controller.table.TableParameters;
import by.example.ClientServer.model.Student;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Objects;

public class Handler {
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public Handler(ObjectInputStream in, ObjectOutputStream out){
        this.in = in;
        this.out = out;
    }

    public void addStudent(Student student){
        sendRequestAndGetResponse(new AddStudentRequest(student));
    }

    public int removeStudentBySurnameOrGroupNumber(String surname, String groupNumber){
        return ((StudentRemoved) Objects.requireNonNull(sendRequestAndGetResponse(
                new RemoveStudentBySoGNRequest(surname, groupNumber)))).getRemovedStudentNum();
    }

    public int removedStudentBySurname(String surname, int minWorkingHours, int maxWorkingHours){
        return ((StudentRemoved) Objects.requireNonNull(sendRequestAndGetResponse(
                new RemoveStudentBySRequest(surname, minWorkingHours, maxWorkingHours)))).getRemovedStudentNum();
    }

    public int removedStudentByGroupNumber(String groupNumber, int minWorkingHours, int maxWorkingHours){
        return ((StudentRemoved) Objects.requireNonNull(sendRequestAndGetResponse
                (new RemoveStudentByGNRequest(groupNumber, minWorkingHours, maxWorkingHours)))).getRemovedStudentNum();
    }

    public void searchStudentBySurnameOrGroupNumber(String surname, String groupNumber){
        sendRequestAndGetResponse(new SearchStudentBySoNGRequest(surname, groupNumber));
    }

    public void searchStudentBySurname(String surname, int minWorkingHours, int maxWorkingHours){
        sendRequestAndGetResponse(new SearchStudentBySRequest(surname, minWorkingHours, maxWorkingHours));
    }

    public void searchStudentByGroupNumber(String groupNumber, int minWorkingHours, int maxWorkingHours){
        sendRequestAndGetResponse(new SearchStudentByGNRequest(groupNumber, minWorkingHours, maxWorkingHours));
    }

    public List<Student> nextPageOn(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new NextPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> prevPageOn(int maxRecordsNum){
        return ((RefreshTablePage)(Objects.requireNonNull(sendRequestAndGetResponse(new PrevPageRequest(maxRecordsNum))))).getNewTablePage();
    }

    public List<Student> firstPageOn(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new FirstPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> lastPageOn(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new LastPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> updatePage(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new UpdatePageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> nextSearchPage(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new NextSearchPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> prevSearchPage(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new PrevSearchPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> firstSearchPage(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new FirstSearchPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<Student> lastSearchPage(int maxRecordsNum){
        return ((RefreshTablePage) Objects.requireNonNull(sendRequestAndGetResponse(new LastSearchPageRequest(maxRecordsNum)))).getNewTablePage();
    }

    public List<String> getGroupNumberList(){
        return ((GroupNUmberListResponse) Objects.requireNonNull(sendRequestAndGetResponse(new GroupNumberListRequest()))).getGroupNumberList();
    }

    public TableParameters getTableParameters(){
        return ((TableParametersResponse) Objects.requireNonNull(sendRequestAndGetResponse(new TableParametersRequest()))).getParameters();
    }

    public void clearList(){
        sendRequestAndGetResponse(new ClearListRequest());
    }

    public void saveFile(String fileName){
        sendRequestAndGetResponse(new SaveFileRequest(fileName));
    }

    public void openFile(String fileName){
        sendRequestAndGetResponse(new OpenFileRequest(fileName));
    }

    public List<String> getFileNameList(){
        return ((FileNameListResponse) Objects.requireNonNull(sendRequestAndGetResponse(new FileNameListRequest()))).getFileNameList();
    }

    private Response sendRequestAndGetResponse(Request request){
        try {
            out.writeObject(request);
            out.flush();
            return (Response) in.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Связь с сервером потеряна!");
            alert.show();
            return null;
        }
    }
}
