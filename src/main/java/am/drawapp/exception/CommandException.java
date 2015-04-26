
package am.drawapp.exception;

/**
 * Exception class for command errors.
 * @author Andrés Mendez Juanias.
 */
public class CommandException extends RuntimeException{

    public CommandException(String message) {
        super(message);
    }
    
}
