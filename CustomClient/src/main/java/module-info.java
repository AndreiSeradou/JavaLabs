module org.example {
    requires javafx.controls;
    requires java.xml;

    exports by.example.ClientServer.view.window;
    exports by.example.ClientServer.model;
    exports by.example.ClientServer.view.сomponent;
    exports by.example.ClientServer.controller.window;
    exports by.example.ClientServer.controller.table;
    exports by.example.ClientServer.controller.handler;
}
