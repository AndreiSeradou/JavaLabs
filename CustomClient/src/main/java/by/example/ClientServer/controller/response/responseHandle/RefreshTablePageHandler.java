package by.example.ClientServer.controller.response.responseHandle;

import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.response.impl.RefreshTablePage;
import by.example.ClientServer.view.window.MainWindow;

public class RefreshTablePageHandler implements ResponseHandler{
    @Override
    public void executeResponse(Response response) {
        //MainWindow.customTable.getTableController().updateTable(((RefreshTablePage)response).getNewTablePage());
    }
}
