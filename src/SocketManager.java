import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/** TO RUN IN CMD:
Go to the command prompt and reach root folder/build/libs.
Enter the command: java –jar <ExecutableJarFileName>.jar.
Verify the result.
 */

public class SocketManager {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        String myIP;
        String sOtherServerIP;

        myIP = "" + (ip.getHostAddress()).trim(); //trims the host name, leaving only the IP

        //get IP address of server to connect to
        System.out.println("Your IP is: " + myIP);
        System.out.print("Enter 1 to connect to this IP or 2 to input manually: ");
        if(new Scanner(System.in).nextInt() == 1){
           sOtherServerIP = myIP;
           System.out.println("accepted IP: " + sOtherServerIP);
        }else {
            System.out.print("Enter IP address of server to connect to: ");
            sOtherServerIP = new Scanner(System.in).nextLine();
        }
        //get port for this server to listen on
        System.out.printf("\n%42s", "Enter port for this server to LISTEN on: ");
        int iPort = new Scanner(System.in).nextInt();

        //Get port for other server.
        System.out.printf("%42s", "Enter port of server to CONNECT to: ");
        int iOtherServerPort = new Scanner(System.in).nextInt();

        SocketServer oServer = new SocketServer(iPort);
        Thread oServerThread = new Thread(oServer);
        oServerThread.start();

        while(true){
            //Get message to send
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Enter message: ");
            String sMessage = new Scanner(System.in).nextLine();

            SocketClient oClient = new SocketClient();
            String sReceivedMessage = oClient.connectForOneMessage(sOtherServerIP, iOtherServerPort, sMessage);

            System.out.println("[Client] reply from server: " + sReceivedMessage);
        }

    }
}
