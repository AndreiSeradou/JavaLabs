package by.example.ClientServer.handlerLoger;

import by.example.ClientServer.view.ServerWindow;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogHandler extends AppenderSkeleton {
    private final ServerWindow window;

    public CustomLogHandler(ServerWindow window){
        this.window = window;
    }

    @Override
    protected void append(LoggingEvent event) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        window.getTextArea().appendText("[" + event.getLevel().toString() + "] " +
                simpleDateFormat.format(new Date(event.timeStamp)) + " " +
                event.getLoggerName() + " - " + event.getMessage().toString() + '\n');
    }
    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }

}