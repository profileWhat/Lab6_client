package commands;

/**
 * Class factory for create show command
 */
public class ShowCommandFactory implements CommandFactory{
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public ShowCommandFactory() {
        this.commandName = CommandName.SHOW;
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
