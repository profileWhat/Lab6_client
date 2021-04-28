package commands;

/**
 * Class factory for create remove_all_by_distance command
 */
public class RemoveAllByDistanceFactory implements CommandFactory {
    private final CommandName commandName;
    private final Double distance;

    /**
     * Constructor for set double distance argument and command type
     * @param distance to set it
     */
    public RemoveAllByDistanceFactory(Double distance) {
        this.commandName = CommandName.REMOVE_ALL_BY_DISTANCE;
        this.distance = distance;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, distance);
    }
}
