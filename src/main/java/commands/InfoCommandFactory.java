package commands;

public class InfoCommandFactory implements CommandFactory {
    private final CommandName commandName;

    public InfoCommandFactory() {
        this.commandName = CommandName.INFO;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
