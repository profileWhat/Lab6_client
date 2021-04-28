package commands;

import collectionManagementModule.Route;

public class RemoveGreaterCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Route route;

    public RemoveGreaterCommandFactory(Route route) {
        this.commandName = CommandName.REMOVE_GREATER;
        this.route = route;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, route);
    }
}
