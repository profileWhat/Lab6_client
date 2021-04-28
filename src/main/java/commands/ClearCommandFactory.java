package commands;

public class ClearCommandFactory implements CommandFactory{
    private CommandName commandsName;

    public ClearCommandFactory() {
        this.commandsName = CommandName.CLEAR;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandsName, null);
    }
}
