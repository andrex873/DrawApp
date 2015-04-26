
package am.drawapp.constants;

import am.drawapp.exception.CommandException;

/**
 *
 * @author amendez
 */
public enum CommandTypeEnum {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET_FILL("B"),
    EXIT("Q");
    
    private final String keyChar;
    
    CommandTypeEnum(String keyChar) {
        this.keyChar = keyChar;
    }

    public String getKeyChar() {
        return keyChar;
    }
    
    public static CommandTypeEnum resolve(String inputCommand) {
        if(inputCommand == null) {
            throw new CommandException(MessageConstants.ERROR_COMMAND_NULL);
        }
        for (CommandTypeEnum commandType : values()) {
            if (inputCommand.startsWith(commandType.getKeyChar())) {
                return commandType;
            }
        }
        throw new CommandException(MessageConstants.ERROR_COMMAND_NOT_FOUND);
    }
    
}
