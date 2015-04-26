
package am.drawapp.command;

import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
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
    
    private int pointX;
    
    private int pointY;
    
    private String colour;

    public BucketFillCommand(String inputCommand) {
        super(inputCommand);
    }

    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException("The command does't have the a valid format. ");
        }
        String[] parts = inputCommand.split(" ");
        pointX = Integer.parseInt(parts[X_POSITION]);
        pointY = Integer.parseInt(parts[Y_POSITION]);
        colour = parts[COLOUR_POSITION];
    }

    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }
    
    public void display(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public String getColour() {
        return colour;
    }
    
}
