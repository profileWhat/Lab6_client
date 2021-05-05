package clientManagementModule;

import IO_utility.InputDeviceWorker;
import IO_utility.OutputDeviceWorker;
import commands.ClientCommand;
import server_messages.ServerMessage;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


/**
 * Class of working with the client
 */
public class ClientWorker {
    private final SocketChannel clientChannel;

    /**
     * Constructor for set socket client
     * @param clientChannel for set it
     */
    public ClientWorker(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    /**
     * Method for start execution of client
     */
    public void start() {
        try {
            InputDeviceWorker.getInputDevice().readCommands(this, System.in);
        } catch (IOException e) {
            OutputDeviceWorker.getDescriber().describeString("The server crashed, the connection is broken");
        }
    }

    /**
     * Method for send command to server
     * @param receivedCommand to sent it to server
     */
    public void sendCommand(ClientCommand receivedCommand) throws IOException{
        ByteBuffer buffer = null;
        try {
            try(ByteArrayOutputStream byteArrayOStream = new ByteArrayOutputStream()) {
                try (ObjectOutputStream out = new ObjectOutputStream(byteArrayOStream)) {
                    out.writeObject(receivedCommand);
                    buffer = ByteBuffer.wrap(byteArrayOStream.toByteArray());
                }
            }
        } catch (IOException e) {
            OutputDeviceWorker.getDescriber().describeString("Error sending the message");
        }
        clientChannel.write(buffer);
    }

    /**
     * Method for get message from server
     * @return message in String format from server
     */
    public ServerMessage getMessage() {
        ServerMessage serverMessage = null;
        byte[] bytes = new byte[32767];
        try {
            BufferedInputStream bInputStream = new BufferedInputStream(clientChannel.socket().getInputStream());
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            bInputStream.read(buffer.array());
            try (ByteArrayInputStream bis = new ByteArrayInputStream(buffer.array());
                 ObjectInputStream in = new ObjectInputStream(bis)) {
                serverMessage = (ServerMessage) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                OutputDeviceWorker.getDescriber().describeString("Error getting the message from server, incorrect type of message");
            }
        } catch (IOException e) {
            OutputDeviceWorker.getDescriber().describeString("Error getting the message from server");
        }
        return serverMessage;
    }

}