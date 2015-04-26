
package am.drawapp;

import am.drawapp.elements.Board;
import am.drawapp.command.CommandFactory;
import am.drawapp.command.DrawCommand;
import am.drawapp.command.ExitCommand;
import am.drawapp.exception.CommandException;
import java.util.Scanner;

/**
 * Draw app in plain text.
 *
 */
public class DrawApp {

    private final Scanner scanner = new Scanner(System.in);

    private final Board board;

    public DrawApp() {
        board = new Board();
    }

    public void start() {
        boolean keepRunning = true;
        do {
            try {
                display("################################################################################\n");
                display("Enter command: ");
                String inputCommand = scanner.nextLine();
                DrawCommand command = CommandFactory.build(inputCommand);
                command.display(board);
                if (command instanceof ExitCommand) {
                    keepRunning = false;
                }
            } catch (CommandException ex) {
                display("ERROR: " + ex.getMessage() + "\n");
            } catch (Exception ex) {
                display("ERROR: " + ex.getMessage() + "\n");
            }
        } while (keepRunning);
        display("Bye!\n");
    }

    private void display(String text) {
        System.out.print(text);
    }

    public static void main(String[] args) {
        new DrawApp().start();
    }
}
