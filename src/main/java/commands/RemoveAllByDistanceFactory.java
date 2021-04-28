package commands;

public class RemoveAllByDistanceFactory implements CommandFactory {
    private CommandName commandName;
    private Double distance;

    public RemoveAllByDistanceFactory(Double distance) {
        this.commandName = CommandName.REMOVE_ALL_BY_DISTANCE;
        this.distance = distance;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, distance);
    }
}
