/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.drawapp.command;

import am.drawapp.constants.CommandTypeEnum;
import am.drawapp.constants.MessageConstants;
import am.drawapp.exception.CommandException;

/**
 *
 * @author amendez
 */
public class CommandFactory {

    public static DrawCommand build(String inputCommand) {
        CommandTypeEnum commandType = CommandTypeEnum.resolve(inputCommand);
        switch (commandType) {
            case CANVAS:
                return new CanvasCommand(inputCommand);
            case LINE:
                return new LineCommand(inputCommand);
            case RECTANGLE:
                return new RectangleComman(inputCommand);
            case BUCKET_FILL:
                return new BucketFillCommand(inputCommand);
            case EXIT:
                return new ExitCommand(inputCommand);
            default:
                throw new CommandException(String.format(MessageConstants.ERROR_COMMAND_UNKNOWN_TYPE, commandType));
        }
    }

}
