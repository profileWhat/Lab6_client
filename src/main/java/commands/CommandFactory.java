package commands;

/**
 * Interface of command Factory for create different type of commands
 */
public interface CommandFactory {
    ReceivedCommand createCommand();
}
