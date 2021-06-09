package by.example.ClientServer.controller.request.impl;

import by.example.ClientServer.controller.request.Request;
import by.example.ClientServer.controller.request.RequestMode;
import by.example.ClientServer.controller.table.TableParameters;

public class TableParametersRequest extends Request {
    public TableParametersRequest() {
        super(RequestMode.TABLE_PARAMETERS);
    }
}
