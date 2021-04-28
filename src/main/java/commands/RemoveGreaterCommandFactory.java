package commands;

import collectionManagementModule.Route;

/**
 * Class factory to create remove_greater command
 */
public class RemoveGreaterCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Route route;

    /**
     * Constructor for set Route argument and set command type
     * @param route to set it
     */
    public RemoveGreaterCommandFactory(Route route) {
        this.commandName = CommandName.REMOVE_GREATER;
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
