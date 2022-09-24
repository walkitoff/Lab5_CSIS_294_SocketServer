import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
    private int thisServerPort;
    private int iMessageSum;
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
                System.out.println("[Server] New client connected: " + oSocket.getRemoteSocketAddress());

                //setup reader
                InputStream input = oSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                //setup writer
                OutputStream output = oSocket.getOutputStream(); //The getOutputStream() returns an output stream for writing bytes to this socket.
                PrintWriter writer = new PrintWriter(output, true);

                //get message from client
                String sRecieveMessage = reader.readLine();
                System.out.println("[Server] Message received from client: " + sRecieveMessage);

                //parse message to int[]
                this.iMessageSum = sumReceiveMessage(sRecieveMessage);

                //Send reply back to client.
                writer.println("Sum from Message: " + this.iMessageSum); //
                //checkError() Flushes the stream if it's not closed and checks its error state.
                //Returns: true if the print stream has encountered an error, either on the underlying output stream or during a format conversion.
                boolean err = writer.checkError();
                if(err){ System.out.println("Error in Print stream found!"); }
            }

        }catch(IOException ex){
            System.out.println("[Server] exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private int sumReceiveMessage(String message){
        String[] temp;
        int sum = 0;

        temp = message.split(",");

        for(int i = 0; i < temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
