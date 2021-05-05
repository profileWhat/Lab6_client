
import clientManagementModule.ClientWorker;
import IO_utility.InputDeviceWorker;
import IO_utility.OutputDeviceWorker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Main class that runs the client
 */
public class Client {
    /**
     * Method for run work of client
     * @param args to set it
     */
    static public void main(String[] args) {
        OutputDeviceWorker.getDescriber().describeString("Enter the server port: ");
        int port = InputDeviceWorker.getInputDevice().waitCorrectIntegerValue();
        SocketAddress socketAddr = new InetSocketAddress("localhost", port);
        try {
            SocketChannel clientSocketChannel = SocketChannel.open(socketAddr);
            OutputDeviceWorker.getDescriber().describeString("Connection established");
            ClientWorker clientWorker = new ClientWorker(clientSocketChannel);
            clientWorker.start();
        } catch (IOException e) {
            System.out.println("Connection cannot be established");
        }
    }

}
