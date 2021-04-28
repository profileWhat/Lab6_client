package commands;

/**
 * Method for create print_field_ascending_distance command
 */
public class PrintFieldAscendingDistanceCommandFactory implements CommandFactory {
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public PrintFieldAscendingDistanceCommandFactory() {
        this.commandName = CommandName.PRINT_FIELD_ASCENDING_DISTANCE;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
