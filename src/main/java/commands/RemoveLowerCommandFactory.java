package commands;

import collectionManagementModule.Route;

/**
 * Class factory for create remove_lower command
 */
public class RemoveLowerCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Route route;

    /**
     * Constructor for set Route argument and command type
     * @param route to set it
     */
    public RemoveLowerCommandFactory(Route route) {
        this.commandName = CommandName.REMOVE_LOWER;
        this.route = route;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, route);
    }
}
