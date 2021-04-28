package commands;

import collectionManagementModule.Route;

/**
 * Class factory for create add command
 */
public class AddCommandFactory implements CommandFactory {
    private final Route route;
    private final CommandName commandName;

    /**
     * Constructor for set argument of command and type of command
     * @param route to set argument
     */
    public AddCommandFactory(Route route) {
        this.route = route;
        this.commandName = CommandName.ADD;
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
