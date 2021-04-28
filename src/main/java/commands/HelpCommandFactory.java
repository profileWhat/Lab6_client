package commands;

/**
 * Class factory for create help command
 */
public class HelpCommandFactory implements CommandFactory {
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public HelpCommandFactory() {
        this.commandName = CommandName.HELP;
    }

    /**
     * Method for create command
     * @return received command that will be send to sever
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
