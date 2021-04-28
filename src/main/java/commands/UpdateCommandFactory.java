package commands;

import collectionManagementModule.CoupleIdRoute;

/**
 * Class factory for create update command
 */
public class UpdateCommandFactory implements CommandFactory {
    private final CommandName commandName;
    private final CoupleIdRoute coupleIdRoute;

    /**
     * Constructor for set CoupleIdRoute argument and command type
     * @param coupleIdRoute to set it
     */
    public UpdateCommandFactory(CoupleIdRoute coupleIdRoute) {
        this.commandName = CommandName.UPDATE;
        this.coupleIdRoute = coupleIdRoute;
    }

    /**
     * Method for create command
     * @return received command that will be send to server
     */
    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, coupleIdRoute);
    }
}
