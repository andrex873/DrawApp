/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package am.drawapp.command;

import am.drawapp.constants.MessageConstants;
import am.drawapp.exception.CommandException;

/**
 *
 * @author amendez
 */
public abstract class AbstractCommand implements DrawCommand {

    public AbstractCommand(String inputCommand) {
        if (inputCommand == null) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_NULL);
        }
        extract(inputCommand);
    }
    
}
