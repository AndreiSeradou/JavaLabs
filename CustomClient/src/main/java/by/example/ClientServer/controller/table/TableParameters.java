package by.example.ClientServer.controller.table;

import java.io.Serializable;

public class TableParameters implements Serializable {
    private static final long serialVersionUID = 1L;

    private int currentPageValue = 0;
    private int lastPageValue = 0;
    private int maxRecordsOnPage = 10;
    private int allRecordsNum;
    private int allPageNum;

    public int getCurrentPageValue() {
        return currentPageValue;
    }

    public int getLastPageValue() {
        return lastPageValue;
    }

    public int getMaxRecordsOnPage() {
        return maxRecordsOnPage;
    }

    public int getAllRecordsNum() {
        return allRecordsNum;
    }

    public int getAllPageNum() {
        return allPageNum;
    }

    public void setCurrentPageValue(int currentPageValue) {
        this.currentPageValue = currentPageValue;
    }

    public void setLastPageValue(int lastPageValue) {
        this.lastPageValue = lastPageValue;
    }

    public void setMaxRecordsOnPage(int maxRecordsOnPage) {
        this.maxRecordsOnPage = maxRecordsOnPage;
    }

    public void setAllRecordsNum(int allRecordsNum) {
        this.allRecordsNum = allRecordsNum;
    }

    public void setAllPageNum(int allPageNum) {
        this.allPageNum = allPageNum;
    }
}
