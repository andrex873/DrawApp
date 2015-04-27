package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.exception.CommandException;

/**
 * The AbstractCommand implements common behavior for the DrawCommand.
 * 
 * @author Andrés Méndez Juanias
 */
public abstract class AbstractCommand implements DrawCommand {

    /**
     * Initializes a new AbstractCommand Object with null validation.
     * @param inputCommand Command in string format.
     */
    public AbstractCommand(String inputCommand) {
        if (inputCommand == null) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_NULL);
        }
        extract(inputCommand);
    }
    
}
