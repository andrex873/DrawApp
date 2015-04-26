
package am.drawapp.command;

import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;

/**
 *
 * @author amendez
 */
public interface DrawCommand {
    
    public void extract(String inputCommand) throws CommandException;
    
    public void display(Board board);
    
}
