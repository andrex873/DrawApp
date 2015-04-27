package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.elements.Coordinate;
import am.drawapp.exception.CommandException;
import am.drawapp.shape.RectangleShape;
import java.util.regex.Pattern;

/**
 *
 * @author amendez
 */
public class RectangleComman extends AbstractCommand {

    /**
     * Pattern to validate the command input.
     */
    private final String PATTERN = "^[R] [1-9][0-9]* [1-9][0-9]* [1-9][0-9]* [1-9][0-9]*$";

    /**
     * Represent the start X position in an array.
     */
    private final int START_POINT_X_POSITION = 1;

    /**
     * Represent the start Y position in an array.
     */
    private final int START_POINT_Y_POSITION = 2;

    /**
     * Represent the end X position in an array.
     */
    private final int END_POINT_X_POSITION = 3;

    /**
     * Represent the end Y position in an array.
     */
    private final int END_POINT_Y_POSITION = 4;

    /**
     * Represent the start coordinate of the command.
     */
    private Coordinate startCoordinate;

    /**
     * Represent the end coordinate of the command.
     */
    private Coordinate endCoordinate;

    /**
     * Initializes a new object of type RectangleComman.
     * @param inputCommand Input command.
     */
    public RectangleComman(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_INVALID_FORMAT);
        }
        String[] parts = inputCommand.split(" ");
        int startPointX = Integer.parseInt(parts[START_POINT_X_POSITION]);
        int startPointY = Integer.parseInt(parts[START_POINT_Y_POSITION]);
        int endPointX = Integer.parseInt(parts[END_POINT_X_POSITION]);
        int endPointY = Integer.parseInt(parts[END_POINT_Y_POSITION]);
        startCoordinate = new Coordinate(startPointX, startPointY);
        endCoordinate = new Coordinate(endPointX, endPointY);
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
        if (!board.isInitialized()) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_CANVAS_NOT_INITIALIZED);
        }
        board.addShape(new RectangleShape(startCoordinate, endCoordinate));
        board.display();
    }

}