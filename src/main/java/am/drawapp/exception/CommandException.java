package am.drawapp.exception;

/**
 * Exception class for command errors.
 * 
 * @author Andrés Mendez Juanias.
 */
public class CommandException extends RuntimeException{

    /**
     * Initializes a new object of type CommandException.
     * @param message Exception message.
     */
    public CommandException(String message) {
        super(message);
    }
    
}
