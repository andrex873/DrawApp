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

    private final String PATTERN = "^[R] [0-9]+ [0-9]+ [0-9]+ [0-9]+$";

    private final int START_POINT_X_POSITION = 1;

    private final int START_POINT_Y_POSITION = 2;

    private final int END_POINT_X_POSITION = 3;

    private final int END_POINT_Y_POSITION = 4;

    private Coordinate startCoordinate;

    private Coordinate endCoordinate;

    public RectangleComman(String inputCommand) {
        super(inputCommand);
    }

    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException("The command does't have the a valid format. ");
        }
        String[] parts = inputCommand.split(" ");
        int startPointX = Integer.parseInt(parts[START_POINT_X_POSITION]);
        int startPointY = Integer.parseInt(parts[START_POINT_Y_POSITION]);
        int endPointX = Integer.parseInt(parts[END_POINT_X_POSITION]);
        int endPointY = Integer.parseInt(parts[END_POINT_Y_POSITION]);
        startCoordinate = new Coordinate(startPointX, startPointY);
        endCoordinate = new Coordinate(endPointX, endPointY);
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
        board.addShape(new RectangleShape(startCoordinate, endCoordinate));
        board.display();
    }

}
