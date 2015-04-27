package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
import java.util.regex.Pattern;

/**
 * The ExitCommand represent a command as an object.
 * @author Andrés Méndez Juanias.
 */
public class ExitCommand extends AbstractCommand {

    /**
     * Pattern to validate the command input.
     */
    private final String PATTERN = "^[Q]$";
    
    /**
     * Initializes a new object of type ExitCommand.
     * @param inputCommand Input command.
     */
    public ExitCommand(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_INVALID_FORMAT);
        }
    }
    
    /**
     * Validate the input command.
     * @param inputCommand Input command.
     * @return True if the command is invalid or False otherwise.
     */
    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }

    @Override
    public void display(Board board) {
    }
    
}