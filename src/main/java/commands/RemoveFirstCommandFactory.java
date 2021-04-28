package commands;

public class RemoveFirstCommandFactory implements CommandFactory {
    private CommandName commandName;

    public RemoveFirstCommandFactory() {
        this.commandName = CommandName.REMOVE_FIRST;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
