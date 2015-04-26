
package am.drawapp.command;

import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
import java.util.regex.Pattern;

/**
 *
 * @author amendez
 */
public class CanvasCommand extends AbstractCommand{
    
    private final String PATTERN = "^[C] [0-9]+ [0-9]+$";
    
    private final int WIDTH_POSITION = 1;
    
    private final int HEIGHT_POSITION = 2;
    
    private int width; 
    
    private int height;

    public CanvasCommand(String inputCommand) {
        super(inputCommand);
    }

    @Override
    public void extract(String inputCommand) throws CommandException {
        // Validate the command format
        if(isInvalid(inputCommand)){
            throw new CommandException("The command does't have the a valid format. ");
        }
        String[] parts = inputCommand.split(" ");
        this.width = Integer.parseInt(parts[WIDTH_POSITION]);
        this.height = Integer.parseInt(parts[HEIGHT_POSITION]);
    }

    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }
    
    public void display(Board board) {
        board.init(width, height);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
