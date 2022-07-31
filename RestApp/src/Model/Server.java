package Model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(666);
        Socket socket = serverSocket.accept();

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String str = dataInputStream.readUTF();
        System.out.println(str);
        serverSocket.close();

    }

}
