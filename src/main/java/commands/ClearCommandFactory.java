package commands;

/**
 * Class factory for create clear command
 */
public class ClearCommandFactory implements CommandFactory{
    private final CommandName commandsName;

    /**
     * Constructor for set command type
     */
    public ClearCommandFactory() {
        this.commandsName = CommandName.CLEAR;
    }

    /**
     * Method for create command
     * @return received command that will be sent to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandsName, null);
    }
}
