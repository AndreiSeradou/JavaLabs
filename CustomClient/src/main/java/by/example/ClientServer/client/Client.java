package by.example.ClientServer.client;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class Client {
    public static ObjectInputStream in;
    public static ObjectOutputStream out;

    public Client(){
        Properties property = new Properties();
        try {
            FileInputStream stream = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\server\\CustomClient\\src\\main\\resources\\port.properties");
            property.load(stream);
            Socket socket = new Socket(property.getProperty("host"), Integer.parseInt(property.getProperty("port")));
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static ObjectInputStream getIn() {
        return in;
    }

    public static ObjectOutputStream getOut() {
        return out;
    }
}
