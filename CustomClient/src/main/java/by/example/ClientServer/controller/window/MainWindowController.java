package by.example.ClientServer.controller.window;

import by.example.ClientServer.view.window.*;

public class MainWindowController {

    public static void setController(MainWindow window){
        tuneMenuButtons(window);
        tuneTableMenuButtons(window);
        tuneMenuBar(window);
    }

    private static void tuneMenuButtons(MainWindow window) {
        window.getSaveButton().setOnAction(actionEvent -> new SaveWindow());
        window.getOpenButton().setOnAction(actionEvent -> {
            new OpenWindow();
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().updatePage(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
        });
        window.getAddButton().setOnAction(actionEvent -> {
            new AddWindow(window.getClient());
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().updatePage(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
        window.getDeleteButton().setOnAction(actionEvent -> {
            new DeleteWindow(window.getClient());
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().updatePage(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
        window.getSearchButton().setOnAction(actionEvent -> new SearchWindow());
        window.getClearButton().setOnAction(actionEvent -> {
            window.getHandler().clearList();
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().updatePage(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
        });
    }

    private static void tuneTableMenuButtons(MainWindow window){
        window.getInfoTable().getNextPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().nextPageOn(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
        window.getInfoTable().getPrevPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().prevPageOn(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
        window.getInfoTable().getFirstPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().firstPageOn(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
        window.getInfoTable().getLastPageButton().setOnAction(actionEvent -> {
            window.getCustomTable().getTableController().updateTable(
                    window.getHandler().lastPageOn(
                            window.getCustomTable().getMaxRecordsNum().getValue()));
            window.getCustomTable().getTableController().updateTableParameters(
                    window.getHandler().getTableParameters()
            );
        });
    }

    private static void tuneMenuBar(MainWindow window){
        window.getMenu().getSaveFile().setOnAction(actionEvent -> window.getSaveButton().fire());
        window.getMenu().getOpenFile().setOnAction(actionEvent -> window.getOpenButton().fire());
        window.getMenu().getAddStudent().setOnAction(actionEvent -> window.getAddButton().fire());
        window.getMenu().getDeleteStudent().setOnAction(actionEvent -> window.getDeleteButton().fire());
        window.getMenu().getSearchStudent().setOnAction(actionEvent -> window.getSearchButton().fire());
    }
}
