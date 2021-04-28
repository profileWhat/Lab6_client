package commands;

public class ExecuteScriptCommandFactory implements CommandFactory{
    private final CommandName commandName;
    private String filePath;

    public ExecuteScriptCommandFactory(String filePath) {
        this.commandName = CommandName.EXECUTE_SCRIPT;
        this.filePath = filePath;
    }

    @Override
    public ReceivedCommand createCommand() {
        return new ReceivedCommand(commandName, filePath);
    }
}
