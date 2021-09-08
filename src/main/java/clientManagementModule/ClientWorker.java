package clientManagementModule;

import IO_utility.InputDeviceWorker;
import IO_utility.OutputDeviceWorker;
import client_messages.ClientCommandMessage;
import client_messages.ClientStringMessage;
import commands.ClientCommand;
import server_messages.ServerMessage;

import java.io.*;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


/**
 * Class of working with the client
 */
public class ClientWorker {
    private SocketChannel clientChannel;
    private boolean serverAvailable;
    private final SocketAddress socketAddr;
    private String userName;
    /**
     * Constructor for set socket client
     * @param socketAddr for set it
     */
    public ClientWorker(SocketAddress socketAddr) {
        this.socketAddr = socketAddr;
    }

    /**
     * Method for start execution of client
     */
    public void start() {
        try {
            this.clientChannel = SocketChannel.open(socketAddr);
            OutputDeviceWorker.getDescriber().describeString("Connection established");
            serverAvailable = true;
            if (InputDeviceWorker.getInputDevice().loginToServer(this, System.in)) {
                InputDeviceWorker.getInputDevice().readCommands(this);
            }
            if (!serverAvailable) {
                OutputDeviceWorker.getDescriber().describeString("Server crashed, if you want to reconnect, enter yes");
                if (InputDeviceWorker.getInputDevice().InputYes()) start();
            }
        } catch (IOException|NullPointerException e) {
            OutputDeviceWorker.getDescriber().describeString("Server crashed, if you want to reconnect, enter yes");
            if (InputDeviceWorker.getInputDevice().InputYes()) start();
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
                    out.writeObject(new ClientCommandMessage(receivedCommand,userName));
                    buffer = ByteBuffer.wrap(byteArrayOStream.toByteArray());
                }
            }
        } catch (IOException e) {
            OutputDeviceWorker.getDescriber().describeString("Error sending the message");
        }
        clientChannel.write(buffer);
    }

    public void sendString(String string) throws IOException {
        ByteBuffer buffer = null;
        try {
            try(ByteArrayOutputStream byteArrayOStream = new ByteArrayOutputStream()) {
                try (ObjectOutputStream out = new ObjectOutputStream(byteArrayOStream)) {
                    out.writeObject(new ClientStringMessage(string));
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
        byte[] bytes = new byte[65567];
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

    public void setNotServerAvailable() {
        this.serverAvailable = false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}