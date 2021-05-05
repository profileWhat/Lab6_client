package clientManagementModule;

import IO_utility.InputDeviceWorker;
import collectionManagementModule.CoupleIdRoute;
import commands.*;

/**
 * Class for create received command using classes factory. That commands will be send to server. Class with pattern singleton and fabric method
 */
public class CommandCreator {
    private static CommandCreator commandCreator;

    /**
     * Private constructor so that you can't create from outside
     */
    private CommandCreator() { }

    /**
     * Static method for return the only one object of CommandCreator
     * @return Command creator object
     */
    public static CommandCreator getCommandCreator() {
        if (commandCreator == null) commandCreator = new CommandCreator();
        return commandCreator;
    }

    /**
     * Method for create command using command factory.
     * @param name to set command type
     * @param argument to set command argument
     * @return received command that was created only by factory
     */
    public ClientCommand createCommand(String name, String argument) throws IncorrectCommandArgumentException {
            ClientCommandName commandName;
            try {
                commandName = ClientCommandName.valueOf(name.toUpperCase());
            } catch (IllegalArgumentException | NullPointerException e) {
                commandName = ClientCommandName.UNDEFINED;
            }
            switch (commandName) {
                case ADD:
                    return new AddCommandFactory(InputDeviceWorker.getInputDevice().inputRoute()).createCommand();
                case CLEAR:
                    return new ClearCommandFactory().createCommand();
                case COUNT_GREATER_THAN_DISTANCE: {
                    double distance;
                    try {
                        distance = Double.parseDouble(argument);
                    } catch (NumberFormatException e) {
                        throw new IncorrectCommandArgumentException("Incorrect double value");
                    }
                    return new CountGreaterThanDistanceCommandFactory(distance).createCommand();
                }
                case EXIT:
                    return new ExitCommandFactory().createCommand();
                case HELP:
                    return new HelpCommandFactory().createCommand();
                case EXECUTE_SCRIPT:
                    return new ExecuteScriptCommandFactory(argument).createCommand();
                case INFO:
                    return new InfoCommandFactory().createCommand();
                case SHOW:
                    return new ShowCommandFactory().createCommand();
                case PRINT_FIELD_ASCENDING_DISTANCE:
                    return new PrintFieldAscendingDistanceCommandFactory().createCommand();
                case REMOVE_ALL_BY_DISTANCE: {
                    double distance;
                    try {
                        distance = Double.parseDouble(argument);
                    } catch (NumberFormatException e) {
                        throw new IncorrectCommandArgumentException("Incorrect double value");
                    }
                    return new RemoveAllByDistanceFactory(distance).createCommand();
                }
                case REMOVE_BY_ID: {
                    long id;
                    try {
                        id = Long.parseLong(argument);
                    } catch (NumberFormatException e) {
                        throw new IncorrectCommandArgumentException("Incorrect double value");
                    }
                    return new RemoveByIdCommandFactory(id).createCommand();
                }
                case REMOVE_GREATER:
                    return new RemoveGreaterCommandFactory(InputDeviceWorker.getInputDevice().inputRoute()).createCommand();
                case REMOVE_LOWER:
                    return new RemoveLowerCommandFactory(InputDeviceWorker.getInputDevice().inputRoute()).createCommand();
                case REMOVE_FIRST:
                    return new RemoveFirstCommandFactory().createCommand();
                case UPDATE: {
                    long id;
                    try {
                        id = Long.parseLong(argument);
                    } catch (NumberFormatException e) {
                        throw new IncorrectCommandArgumentException("Incorrect double value");
                    }
                    return new UpdateCommandFactory(new CoupleIdRoute(id, InputDeviceWorker.getInputDevice().inputRoute())).createCommand();
                }
                default: return new UndefinedCommandFactory().createCommand();
            }

    }
}
