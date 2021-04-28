package commands;

/**
 * Class factory to create count_greater_than_distance command
 */
public class CountGreaterThanDistanceCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Double distance;

    /**
     * Constructor for set distance argument and command type
     * @param distance set argument of command
     */
    public CountGreaterThanDistanceCommandFactory(Double distance) {
        this.commandName = CommandName.COUNT_GREATER_THAN_DISTANCE;
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
