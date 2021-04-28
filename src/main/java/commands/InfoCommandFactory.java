package commands;

/**
 * Class factory for create info command
 */
public class InfoCommandFactory implements CommandFactory {
    private final CommandName commandName;

    /**
     * Constructor for set command type
     */
    public InfoCommandFactory() {
        this.commandName = CommandName.INFO;
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
