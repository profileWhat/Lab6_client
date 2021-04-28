package commands;

import clientManagementModule.IncorrectCommandArgumentException;
import clientManagementModule.InputDeviceWorker;
import collectionManagementModule.CoupleIdRoute;

public class CommandCreator {

    private static CommandCreator commandCreator;

    private CommandCreator() { }

    public static CommandCreator getCommandCreator() {
        if (commandCreator == null) commandCreator = new CommandCreator();
        return commandCreator;
    }

    public ReceivedCommand createCommand(String name, String argument) {
            CommandName commandName;
            try {
                commandName = CommandName.valueOf(name.toUpperCase());
            } catch (IllegalArgumentException | NullPointerException e) {
                commandName = CommandName.UNDEFINED;
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
                default: return new ReceivedCommand(CommandName.UNDEFINED, null);
            }

    }
}
