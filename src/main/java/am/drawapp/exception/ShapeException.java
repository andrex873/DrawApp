package am.drawapp.exception;

/**
 * Exception class for shape errors.
 * 
 * @author Andrés Mendez Juanias.
 */
public class ShapeException extends RuntimeException{

    /**
     * Initializes a new object of type ShapeException.
     * @param message Exception message.
     */
    public ShapeException(String message) {
        super(message);
    }    
}