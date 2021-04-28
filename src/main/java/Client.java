
import clientManagementModule.ClientWorker;
import clientManagementModule.OutputDeviceWorker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Main class that runs the program
 */
public class Client {
   private static SocketAddress socketAddr = new InetSocketAddress("localhost", 1221);
    static public void main(String[] args) {
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(socketAddr);
            OutputDeviceWorker.getDescriber().describeString("Connection established");
            ClientWorker clientWorker = new ClientWorker(clientSocketChannel.socket());
            clientWorker.start();
        } catch (IOException e) {
            System.out.println("Connection cannot be established");
        }
    }

}
