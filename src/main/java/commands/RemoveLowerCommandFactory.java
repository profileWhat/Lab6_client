package commands;

import collectionManagementModule.Route;

public class RemoveLowerCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private final Route route;

    public RemoveLowerCommandFactory(Route route) {
        this.commandName = CommandName.REMOVE_LOWER;
        this.route = route;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, route);
    }
}
