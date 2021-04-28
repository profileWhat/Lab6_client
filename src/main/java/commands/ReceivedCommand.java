package commands;

import java.io.Serializable;

/**
 * Class received command that will be send of server. That class you can get only with command factory
 */
public class ReceivedCommand implements Serializable {
    private static final long serialVersionUID = 1L;
    private final CommandName commandsName;
    private final Object argument;

    /**
     * Constructor for set command type and argument
     * @param commandsName to set it
     * @param argument to set it
     */
    protected ReceivedCommand(CommandName commandsName, Object argument) {
        this.commandsName = commandsName;
        this.argument = argument;
    }

    /**
     * Method for get argument, this method useless on client, but it uses on server
     * @return argument
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Method for get command name, this method useless on client, but it uses on server
     * @return command name
     */
    public CommandName getCommandsName() {
        return commandsName;
    }


}
