/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;
import java.util.regex.Pattern;

/**
 *
 * @author amendez
 */
public class LineCommand extends AbstractCommand{
    
    private final String PATTERN = "^[L] [0-9]+ [0-9]+ [0-9]+ [0-9]+$";
    
    private final int START_POINT_X_POSITION = 1;
    
    private final int START_POINT_Y_POSITION = 2;
    
    private final int END_POINT_X_POSITION = 3;
    
    private final int END_POINT_Y_POSITION = 4;
    
    private int startPointX;
    
    private int startPointY;
    
    private int endPointX;
    
    private int endPointY;
    

    public LineCommand(String inputCommand) {
        super(inputCommand);
    }

    public void extract(String inputCommand) throws CommandException {
        if (isInvalid(inputCommand)) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_INVALID_FORMAT);
        }
        String[] parts = inputCommand.split(" ");
        startPointX = Integer.parseInt(parts[START_POINT_X_POSITION]);
        startPointY = Integer.parseInt(parts[START_POINT_Y_POSITION]);
        endPointX = Integer.parseInt(parts[END_POINT_X_POSITION]);
        endPointY = Integer.parseInt(parts[END_POINT_Y_POSITION]);
    }
    
    private boolean isInvalid(String inputCommand) {
        Pattern patter = Pattern.compile(PATTERN);
        return !patter.matcher(inputCommand).matches();
    }

    public void display(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getStartPointX() {
        return startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public int getEndPointX() {
        return endPointX;
    }

    public int getEndPointY() {
        return endPointY;
    }

}
