package exceptions;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Anda telah mencapai jemlah batas login");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
