package IO_utility;

import clientManagementModule.*;
import collectionManagementModule.Coordinates;
import collectionManagementModule.LocationFrom;
import collectionManagementModule.LocationTo;
import collectionManagementModule.Route;
import commands.ClientCommand;
import server_messages.ServerMessage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class for working with the input device
 */
public class InputDeviceWorker {
    private final Scanner reader;
    static private InputDeviceWorker inputDeviceWorker;
    private final CorrectValuePullout correctValuePullout;

    private InputDeviceWorker() {
        this.correctValuePullout = new CorrectValuePullout();
        this.reader = new Scanner(System.in);
    }

    /**
     * Static Method to init Input Device for the first time and then get this Input Device.
     *
     * @return Input Device
     */
    public static InputDeviceWorker getInputDevice() {
        if (InputDeviceWorker.inputDeviceWorker == null) InputDeviceWorker.inputDeviceWorker = new InputDeviceWorker();
        return InputDeviceWorker.inputDeviceWorker;
    }

    /**
     * Method for wait and return Double Value
     *
     * @return Double Value
     */
    public Double waitCorrectDoubleValue() {
        Double value = null;
        while (value == null) {
            try {
                String line = reader.nextLine();
                value = correctValuePullout.getDoubleValue(line);
            } catch (IncorrectValueException e) {
                OutputDeviceWorker.getDescriber().describeException(e);
            }
        }
        return (value);
    }

    /**
     * Method for wait and return Long Value
     *
     * @return Long Value
     */
    public Long waitCorrectLongValue() {
        Long value = null;
        while (value == null) {
            try {
                String line = reader.nextLine();
                value = correctValuePullout.getLongValue(line);
            } catch (IncorrectValueException e) {
                OutputDeviceWorker.getDescriber().describeException(e);
            }
        }
        return (value);
    }

    /**
     * Method for wait and return Integer Value
     *
     * @return Integer Value
     */
    public Integer waitCorrectIntegerValue() {
        Integer value = null;
        while (value == null) {
            try {
                String line = reader.nextLine();
                value = correctValuePullout.getIntegerValue(line);
            } catch (IncorrectValueException e) {
                OutputDeviceWorker.getDescriber().describeException(e);
            }
        }
        return (value);
    }

    /**
     * Method for wait and return Float Value
     *
     * @return Float Value
     */
    public Float waitCorrectFloatValue() {
        Float value = null;
        while (value == null) {
            try {
                String line = reader.nextLine();
                value = correctValuePullout.getFloatValue(line);
            } catch (IncorrectValueException e) {
                OutputDeviceWorker.getDescriber().describeException(e);
            }
        }
        return (value);
    }

    /**
     * Method for read words, send them to server and write a received message from server
     */
    public void readCommands(ClientWorker clientWorker, InputStream in) throws IOException{
        Scanner reader = new Scanner(in);
        String regex = "(?:\\w[,./:]?)+";
        Pattern p = Pattern.compile(regex);
        String currentString;
        String commandName ;
        while (true) {
            if (!reader.hasNext()) break;
            currentString = reader.nextLine();
            Matcher matcher = p.matcher(currentString);
            ArrayDeque<String> lineWords = new ArrayDeque<>();
            while (matcher.find()) {
                lineWords.add(currentString.substring(matcher.start(), matcher.end()));
            }
            commandName = lineWords.pollFirst();
            String commandArgument = lineWords.pollFirst();
            try {
                ClientCommand receivedCommand = CommandCreator.getCommandCreator().createCommand(commandName, commandArgument);
                clientWorker.sendCommand(receivedCommand);
                ServerMessage serverMessage = clientWorker.getMessage();
                String message = serverMessage.getMessage();
                System.out.println(message);
                if (serverMessage.isEndOfScriptExFlag()) {
                    break;
                }
                if (Objects.equals(commandName, "exit")) break;
                try {
                    if (Objects.equals(commandName, "execute_script"))
                        if (commandArgument != null) {
                            readCommands(clientWorker, new FileInputStream(commandArgument));
                        }
                } catch (IOException e) {
                    OutputDeviceWorker.getDescriber().describeString("the path to execute the script was not found");
                }
            } catch (IncorrectCommandArgumentException e) {
                OutputDeviceWorker.getDescriber().describeException(e);
            }
        }
    }

    /**
     * Method for input Route
     *
     * @return Route
     */
    public Route inputRoute() {

        OutputDeviceWorker.getDescriber().describeString("Enter the route name: ");
        String routeName = reader.nextLine();

        OutputDeviceWorker.getDescriber().describeString("Enter the Integer X coordinate: ");
        int xCoordinate = waitCorrectIntegerValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the Float Y coordinate: ");
        float yCoordinate = waitCorrectFloatValue();
        Coordinates routeCoordinates = new Coordinates(xCoordinate, yCoordinate);

        OutputDeviceWorker.getDescriber().describeString("Enter the Integer X Location From coordinate: ");
        Integer xFromCoordinate = waitCorrectIntegerValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the Long Y Location From coordinate: ");
        Long yFromCoordinate = waitCorrectLongValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the Integer Z Location From coordinate: ");
        int zFromCoordinate = waitCorrectIntegerValue();
        LocationFrom routeFrom = new LocationFrom(xFromCoordinate, yFromCoordinate, zFromCoordinate);

        OutputDeviceWorker.getDescriber().describeString("Enter the Long X Location To coordinate: ");
        long xToCoordinate = waitCorrectIntegerValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the Double Y Location To coordinate: ");
        double yToCoordinate = waitCorrectDoubleValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the Integer Z Location To coordinate: ");
        Integer zToCoordinate = waitCorrectIntegerValue();
        OutputDeviceWorker.getDescriber().describeString("Enter the name of Location To: ");
        String nameLocationTo = reader.nextLine();
        LocationTo routeTo = new LocationTo(xToCoordinate, yToCoordinate, zToCoordinate, nameLocationTo);

        return (new Route(routeName, routeCoordinates, routeFrom, routeTo));
    }
}
