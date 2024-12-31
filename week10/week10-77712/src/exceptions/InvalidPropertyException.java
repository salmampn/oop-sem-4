package exceptions;

public class InvalidPropertyException extends Exception {
    public InvalidPropertyException() {
        super("Input data tidak valid");
    }

    public InvalidPropertyException(String message) {
        super(message);
    }
}
