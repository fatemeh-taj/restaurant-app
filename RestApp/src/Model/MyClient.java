
package Model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {

    public MyClient() throws IOException {
        
        Socket socket=new Socket("localhost",6666);
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("");
        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }
}
    
    
    
    class TH extends Thread{
        
        DBHandler dBHandler=new DBHandler();
        TH() throws IOException{
            dBHandler.connect();
        }
    }
    
    
