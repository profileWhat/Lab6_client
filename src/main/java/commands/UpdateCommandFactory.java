package commands;

import collectionManagementModule.CoupleIdRoute;

public class UpdateCommandFactory implements CommandFactory {
    private final CommandName commandName;
    private final CoupleIdRoute coupleIdRoute;
    public UpdateCommandFactory(CoupleIdRoute coupleIdRoute) {
        this.commandName = CommandName.UPDATE;
        this.coupleIdRoute = coupleIdRoute;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, coupleIdRoute);
    }
}
