package by.example.ClientServer.controller.table;

public class TableController {
    public static void tuneTableParameters(TableParameters parameters, int repositorySize){
        if(repositorySize == 0){
            parameters.setCurrentPageValue(0);
            parameters.setLastPageValue(0);
            return;
        }

        if(repositorySize <= parameters.getMaxRecordsOnPage() || parameters.getMaxRecordsOnPage() == 0)
            parameters.setLastPageValue(0);
        else if(repositorySize%parameters.getMaxRecordsOnPage() > 0)
            parameters.setLastPageValue(repositorySize/parameters.getMaxRecordsOnPage());
        else
            parameters.setLastPageValue(repositorySize/parameters.getMaxRecordsOnPage() - 1);

        if(parameters.getCurrentPageValue() > parameters.getLastPageValue())
            parameters.setCurrentPageValue(parameters.getLastPageValue());


        parameters.setAllPageNum(parameters.getLastPageValue());
        parameters.setAllRecordsNum(repositorySize);
    }

    public static void incrementPage(TableParameters parameters){
        parameters.setCurrentPageValue(parameters.getCurrentPageValue() + 1);
    }

    public static void decrementPage(TableParameters parameters){
        if(parameters.getCurrentPageValue() > 0){
            parameters.setCurrentPageValue(parameters.getCurrentPageValue() - 1);
        }
    }

    public static void turnFirstPage(TableParameters parameters){
        parameters.setCurrentPageValue(0);
    }

    public static void turnLastPage(TableParameters parameters){
        parameters.setCurrentPageValue(parameters.getLastPageValue());
    }

    public static void tuneMaxRecordsNum(TableParameters parameters, int maxRecordsNum){
        parameters.setMaxRecordsOnPage(maxRecordsNum);
    }
}
