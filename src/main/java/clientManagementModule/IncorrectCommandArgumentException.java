package clientManagementModule;

/**
 * Exception class that is thrown when the program argument is incorrect
 */
public class IncorrectCommandArgumentException extends NumberFormatException {
    public IncorrectCommandArgumentException(String message) {
        super(message);
    }
}
