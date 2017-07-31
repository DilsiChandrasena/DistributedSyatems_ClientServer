import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket=new Socket("localhost",3333);

            DataOutputStream dataOutPutStream=new DataOutputStream(socket.getOutputStream());

            dataOutPutStream.writeUTF("Hello Server");
            dataOutPutStream.flush();

            dataOutPutStream.close();
            socket.close();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
