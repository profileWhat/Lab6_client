package commands;

public class ShowCommandFactory implements CommandFactory{
    private final CommandName commandName;

    public ShowCommandFactory() {
        this.commandName = CommandName.SHOW;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
