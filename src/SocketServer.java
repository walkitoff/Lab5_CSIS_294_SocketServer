import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
    private int thisServerPort;

    /**
     * Constructor forces PORT to be passed in that is necessary for ServerSocket startup.
     */
    public SocketServer(int iPort){
        this.thisServerPort = iPort;
    }

    /**
     * This thread listens for connecting clients and receives messages.
     */
    public void run(){

        try(ServerSocket oServerSocket = new ServerSocket(thisServerPort)){
            System.out.println("[Server] is listening on port: " + this.thisServerPort);

            while(true){
                //waiting for client to connect to server
                Socket oSocket = oServerSocket.accept();
                System.out.println("[Server]  New client connected: " + oSocket.getRemoteSocketAddress());

                //setup reader
                InputStream input = oSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                //setup writer
                OutputStream output = oSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                //get message from client
                String sRecieveMessage = reader.readLine();
                System.out.println("[Server] message received from client: " + sRecieveMessage);

                //Send reply back to client.
                writer.println("Server received your message: " + sRecieveMessage);
                writer.flush();
            }

        }catch(IOException ex){
            System.out.println("[Server] exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
