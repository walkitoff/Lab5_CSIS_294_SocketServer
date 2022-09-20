import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {

        //get port for this server to listen on
        System.out.print("Enter port for this server to listen on: ");
        int iPort = new Scanner(System.in).nextInt();

        //get IP address of server to connect to
        System.out.print("Enter IP address of server to connect to: ");
        String sOtherServerIP = new Scanner(System.in).nextLine();

        //Get port for other server.
        System.out.print("Enter port of server to connect to: ");
        int iOtherServerPort = new Scanner(System.in).nextInt();

        SocketServer oServer = new SocketServer(iPort);
        Thread oServerThread = new Thread(oServer);
        oServerThread.start();

        while(true){
            //Get message to send
            System.out.print("Enter message: ");
            String sMessage = new Scanner(System.in).nextLine();

            SocketClient oClient = new SocketClient();
            String sReceivedMessage = oClient.connectForOneMessage(sOtherServerIP, iOtherServerPort, sMessage);

            System.out.println("[Client] reply from server: " + sReceivedMessage);
        }

    }
}
