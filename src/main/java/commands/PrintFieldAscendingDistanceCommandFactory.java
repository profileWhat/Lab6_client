package commands;

public class PrintFieldAscendingDistanceCommandFactory implements CommandFactory {
    private final CommandName commandName;

    public PrintFieldAscendingDistanceCommandFactory() {
        this.commandName = CommandName.PRINT_FIELD_ASCENDING_DISTANCE;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
