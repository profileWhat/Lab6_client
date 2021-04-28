package commands;

/**
 * Class factory for create remove_first command
 */
public class RemoveFirstCommandFactory implements CommandFactory {
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public RemoveFirstCommandFactory() {
        this.commandName = CommandName.REMOVE_FIRST;
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
