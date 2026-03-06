package Exception;

/**
 * Represents an exception specific to the CAPO application
 * <p>
 * This exception is thrown when an error occurs during command parsing,
 * task processing, or storage operations within the program
 */
public class CapoException extends Exception{

    /**
     * Creates a CapoException with the specified error message.
     *
     * @param message The message describing the cause of the exception.
     */
    public CapoException(String message){
        super(message);
    }
}
