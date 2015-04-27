package am.drawapp;

import am.drawapp.elements.Board;
import am.drawapp.command.CommandFactory;
import am.drawapp.command.DrawCommand;
import am.drawapp.command.ExitCommand;
import am.drawapp.exception.CommandException;
import am.drawapp.exception.ShapeException;
import java.util.Scanner;

/**
 * The DrawApp represent the main application and the start point to
 * draw.
 *
 * @author Andrés Méndez Juanias.
 */
public class DrawApp {

    /**
     * Scanner to reade the commands from console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Represent the board in the drawing tool.
     */
    private final Board board;

    /**
     * Initializes a new DrawApp Object.
     */
    public DrawApp() {
        board = new Board();
    }

    /**
     * Start de Drawing tool logic.
     */
    public void start() {
        boolean keepRunning = true;
        do {
            try {
                printHeader();
                String inputCommand = scanner.nextLine();
                DrawCommand command = CommandFactory.build(inputCommand);
                command.display(board);
                if (command instanceof ExitCommand) {
                    keepRunning = false;
                }
            } catch (CommandException | ShapeException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        } while (keepRunning);
        System.out.println("Bye!");
    }

    /**
     * Print the header of the application.
     */
    private void printHeader() {
        System.out.println("################################################################################");
        System.out.print("Enter command: ");
    }

    /**
     * Main method to start the Drawing tool.
     *
     * @param args Command arguments.
     */
    public static void main(String[] args) {
        new DrawApp().start();
    }
}
