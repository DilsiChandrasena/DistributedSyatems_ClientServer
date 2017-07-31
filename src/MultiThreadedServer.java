import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class MultiThreadedServer implements Runnable {
    Socket socket;
    static Queue<Socket> queue=new ArrayDeque<Socket>();

    MultiThreadedServer(Socket socket) {

        this.socket = socket;
    }
    public static void main(String args[]) throws Exception {
	
	int n = Integer.parseInt(args[0]);
        System.out.println("Enter the size of thread pool:- "+n);

        int noOfClient = 1;
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Listening...");

        while (true) {

            if (noOfClient <= n) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " +noOfClient + " is connected ");
                new Thread(new MultiThreadedServer(socket)).start();
                noOfClient++;
            }else {
                System.out.println("Client " + noOfClient + "is added to Queue");
                Socket socket = serverSocket.accept();
                queue.add(socket);
                noOfClient++;

            }

        }

    }

    @Override
    public void run() {
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}




