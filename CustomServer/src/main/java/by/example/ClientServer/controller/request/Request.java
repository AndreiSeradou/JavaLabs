package by.example.ClientServer.controller.request;

import java.io.Serializable;

public abstract class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final RequestMode requestMode;

    protected Request(RequestMode requestMode) {
        this.requestMode = requestMode;
    }

    public RequestMode getRequestMode(){
        return requestMode;
    }
}
