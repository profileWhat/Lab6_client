package commands;

import collectionManagementModule.Route;

public class AddCommandFactory implements CommandFactory {
    private Route route;
    private CommandName commandName;

    public AddCommandFactory(Route route) {
        this.route = route;
        this.commandName = CommandName.ADD;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, route);
    }
}
