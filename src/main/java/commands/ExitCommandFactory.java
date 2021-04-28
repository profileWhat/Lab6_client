package commands;

/**
 * Class factory for create exit command
 */
public class ExitCommandFactory implements CommandFactory {
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public ExitCommandFactory() {
        this.commandName = CommandName.EXIT;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, null);
    }
}
