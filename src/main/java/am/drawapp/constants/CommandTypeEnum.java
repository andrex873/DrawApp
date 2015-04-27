package am.drawapp.constants;

import am.drawapp.exception.CommandException;

/**
 * Enum that represents the command types.
 * 
 * @author Andrés Méndez Juanias.
 */
public enum CommandTypeEnum {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET_FILL("B"),
    EXIT("Q");
    
    /**
     * Character key of the command.
     */
    private final String keyChar;
    
    /**
     * Initializes a new CommandTypeEnum.
     * @param keyChar Key char of the command.
     */
    CommandTypeEnum(String keyChar) {
        this.keyChar = keyChar;
    }

    /**
     * Return the key char of the command type.
     * @return The key character.
     */
    public String getKeyChar() {
        return keyChar;
    }
    
    /**
     * Resolve the command type from the string command.
     * @param inputCommand Input commad.
     * @return The CommandTypeEnum.
     */
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