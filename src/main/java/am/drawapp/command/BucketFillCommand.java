
package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.elements.Cell;
import am.drawapp.elements.Coordinate;
import am.drawapp.elements.CustomCell;
import am.drawapp.exception.CommandException;
import am.drawapp.shape.BucketFillShape;
import java.util.regex.Pattern;

/**
 *
 * @author amendez
 */
public class BucketFillCommand extends AbstractCommand {
    
    private final String PATTERN = "^[B] [0-9]+ [0-9]+ [a-zA-Z0-9]$";
    
    private final int X_POSITION = 1;
    
    private final int Y_POSITION = 2;
    
    private final int COLOUR_POSITION = 3;
    
    private Coordinate coordinate;
    
    private Cell colour;

    public BucketFillCommand(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException("The command does't have the a valid format. ");
        }
        String[] parts = inputCommand.split(" ");
        int pointX = Integer.parseInt(parts[X_POSITION]);
        int pointY = Integer.parseInt(parts[Y_POSITION]);
        coordinate = new Coordinate(pointX, pointY);
        colour = new CustomCell(parts[COLOUR_POSITION]);
    }

    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }
    
    @Override
    public void display(Board board) {
        if (!board.isInitialized()) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_CANVAS_NOT_INITIALIZED);
        }
        board.addShape(new BucketFillShape(board.getBoardMap(), coordinate, colour));
        board.display();
    }

}
