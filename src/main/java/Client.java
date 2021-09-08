
import clientManagementModule.ClientWorker;
import IO_utility.InputDeviceWorker;
import IO_utility.OutputDeviceWorker;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Main class that runs the client
 */
public class Client {
    /**
     * Method for run work of client
     * @param args to set it
     */
    static public void main(String[] args) {
        OutputDeviceWorker.getDescriber().describeString("Enter the IPv4 Address: ");
        String ipv4 = InputDeviceWorker.getInputDevice().waitCorrectIPv4();
        OutputDeviceWorker.getDescriber().describeString("Enter the server port: ");
        int port = InputDeviceWorker.getInputDevice().waitCorrectIntegerValue();
        SocketAddress socketAddr = new InetSocketAddress(ipv4, port);
        ClientWorker clientWorker = new ClientWorker(socketAddr);
        clientWorker.start();

    }

}
