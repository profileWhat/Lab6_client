package commands;

public class CountGreaterThanDistanceCommandFactory implements CommandFactory{
    private CommandName commandName;
    private Double distance;

    public CountGreaterThanDistanceCommandFactory(Double distance) {
        this.commandName = CommandName.COUNT_GREATER_THAN_DISTANCE;
        this.distance = distance;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, distance);
    }
}
