package by.example.ClientServer.controller.table;

import by.example.ClientServer.model.Student;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    public static List<Student> getPage(List<Student> studentList, TableParameters parameters){
        List<Student> page = new ArrayList<>();

        if(studentList.size() <= parameters.getMaxRecordsOnPage()){
            page.addAll(studentList);
            parameters.setCurrentPageValue(0);
        }else {
            int fromIndex = parameters.getMaxRecordsOnPage() * parameters.getCurrentPageValue();
            int toIndex = parameters.getMaxRecordsOnPage() * parameters.getCurrentPageValue() +
                    Math.min(parameters.getMaxRecordsOnPage(), studentList.size() -
                            parameters.getMaxRecordsOnPage() * parameters.getCurrentPageValue());
            page.addAll(studentList.subList(fromIndex, toIndex));
        }
        return page;
    }
}
