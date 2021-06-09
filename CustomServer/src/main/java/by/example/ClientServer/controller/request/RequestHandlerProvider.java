package by.example.ClientServer.controller.request;

import by.example.ClientServer.controller.request.requestHandle.*;

import java.util.HashMap;
import java.util.Map;

public class RequestHandlerProvider {
    Map<RequestMode, RequestHandler> requestMap;
    public RequestHandlerProvider(){
        requestMap = new HashMap<>();
        requestMap.put(RequestMode.ADD_STUDENT, new AddStudentHandle());
        requestMap.put(RequestMode.DELETE_STUDENT_BY_SURNAME_OR_GROUP_NUMBER, new RemoveStudentHandler());
        requestMap.put(RequestMode.DELETE_STUDENT_BY_SURNAME, new RemoveStudentHandler());
        requestMap.put(RequestMode.DELETE_STUDENT_BY_GROUP_NUMBER, new RemoveStudentHandler());
        requestMap.put(RequestMode.SEARCH_STUDENT_BY_SURNAME_OR_GROUP_NUMBER, new SearchStudentHandler());
        requestMap.put(RequestMode.SEARCH_STUDENT_BY_SURNAME, new SearchStudentHandler());
        requestMap.put(RequestMode.SEARCH_STUDENT_BY_GROUP_NUMBER, new SearchStudentHandler());
        requestMap.put(RequestMode.NEXT_PAGE, new NextPageHandle());
        requestMap.put(RequestMode.PREV_PAGE, new PrevPageHandle());
        requestMap.put(RequestMode.FIRST_PAGE, new FirstPageHandle());
        requestMap.put(RequestMode.LAST_PAGE, new LastPageHandle());
        requestMap.put(RequestMode.NEXT_SEARCH_PAGE, new NextSearchPageHandle());
        requestMap.put(RequestMode.PREV_SEARCH_PAGE, new PrevSearchPageHandle());
        requestMap.put(RequestMode.FIRST_SEARCH_PAGE, new FirstSearchPageHandle());
        requestMap.put(RequestMode.LAST_SEARCH_PAGE, new LastSearchPageHandle());
        requestMap.put(RequestMode.GROUP_NUMBER_LIST, new GroupNumberListHandle());
        requestMap.put(RequestMode.UPDATE_TABLE, new UpdateTableHandle());
        requestMap.put(RequestMode.TABLE_PARAMETERS, new TableParametersHandle());
        requestMap.put(RequestMode.SAVE_FILE, new SaveFileHandle());
        requestMap.put(RequestMode.OPEN_FILE, new OpenFileHandle());
        requestMap.put(RequestMode.FILE_NAME_LIST, new FileNameListHandle());
        requestMap.put(RequestMode.CLEAR_LIST, new ClearListHandle());
    }

    public RequestHandler getRequestHandler(RequestMode requestMode){
        return requestMap.get(requestMode);
    }
}
