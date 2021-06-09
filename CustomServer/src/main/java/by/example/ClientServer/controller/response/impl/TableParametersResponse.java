package by.example.ClientServer.controller.response.impl;

import by.example.ClientServer.controller.response.Response;
import by.example.ClientServer.controller.table.TableParameters;

public class TableParametersResponse extends Response {

    private final TableParameters parameters;

    public TableParametersResponse(TableParameters parameters) {
        this.parameters = parameters;
    }

    public TableParameters getParameters() {
        return parameters;
    }
}
