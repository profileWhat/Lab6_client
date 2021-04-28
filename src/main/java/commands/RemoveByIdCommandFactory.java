package commands;

/**
 * Class factory for create remove_by_id command
 */
public class RemoveByIdCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Long id;

    /**
     * Constructor for set Long if argument and command type
     * @param id to set it
     */
    public RemoveByIdCommandFactory(Long id) {
        this.commandName = CommandName.REMOVE_BY_ID;
        this.id = id;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, id);
    }
}
