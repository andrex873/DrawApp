package am.drawapp.command;

import am.drawapp.elements.Board;
import am.drawapp.exception.CommandException;

/**
 * Interface thata representa a Command.
 *
 * @author Andrés Méndez Juanias.
 */
public interface DrawCommand {

    /**
     * Extrac the information from an input command.
     *
     * @param inputCommand Input command.
     * @throws CommandException If the extract fails.
     */
    public void extract(String inputCommand) throws CommandException;

    /**
     * Method to print the canvas.
     *
     * @param board Board object.
     */
    public void display(Board board);

}
