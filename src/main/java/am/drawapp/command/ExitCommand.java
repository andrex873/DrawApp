
package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
import java.util.regex.Pattern;

/**
 *
 * @author amendez
 */
public class ExitCommand extends AbstractCommand {

    private final String PATTERN = "^[Q]$";
    
    public ExitCommand(String inputCommand) {
        super(inputCommand);
    }

    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_INVALID_FORMAT);
        }
    }
    
    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }

    public void display(Board board) {
        return;
    }
    
}
