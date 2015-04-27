package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
import am.drawapp.shape.BorderShape;
import java.util.regex.Pattern;

/**
 * The CanvasCommand represent a command as an object.
 * 
 * @author Andrés Méndez Juanias.
 */
public class CanvasCommand extends AbstractCommand{
    
    /**
     * Pattern to validate the command input.
     */
    private final String PATTERN = "^[C] [1-9]+ [1-9]+$";
    
    /**
     * Represent the width position in an array.
     */
    private final int WIDTH_POSITION = 1;
    
    /**
     * Represent the height position in an array.
     */
    private final int HEIGHT_POSITION = 2;
    
    /**
     * Represent the width of the canvas.
     */
    private int width; 
    
    /**
     * Represent the height of the canvas.
     */
    private int height;

    /**
     * Initializes a new object of type CanvasCommand.
     * @param inputCommand Command in string format.
     */
    public CanvasCommand(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void extract(String inputCommand) throws CommandException {
        // Validate the command format
        if(isInvalid(inputCommand)){
            throw new CommandException(MessageConstants.ERROR_COMMAND_INVALID_FORMAT);
        }
        String[] parts = inputCommand.split(" ");
        this.width = Integer.parseInt(parts[WIDTH_POSITION]);
        this.height = Integer.parseInt(parts[HEIGHT_POSITION]);
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
        board.init(width, height);
        board.addShape(new BorderShape(width, height));
        board.display();
    }

}