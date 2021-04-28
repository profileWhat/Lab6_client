package commands;

public class ExitCommandFactory implements CommandFactory {
    private final CommandName commandName;

    public ExitCommandFactory() {
        this.commandName = CommandName.EXIT;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
