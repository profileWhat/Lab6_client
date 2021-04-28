package commands;

public class HelpCommandFactory implements CommandFactory {
    private CommandName commandName;

    public HelpCommandFactory() {
        this.commandName = CommandName.HELP;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
