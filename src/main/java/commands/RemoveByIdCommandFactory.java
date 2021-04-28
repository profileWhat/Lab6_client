package commands;

public class RemoveByIdCommandFactory implements CommandFactory{
    private CommandName commandName;
    private Long id;

    public RemoveByIdCommandFactory(Long id) {
        this.commandName = CommandName.REMOVE_BY_ID;
        this.id = id;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, id);
    }
}
