package exceptions;

public class ExcessiveFailedLoginException extends Exception {
    public ExcessiveFailedLoginException() {
        super("Anda Telah mencapai jumlah batas login");
    }

    public ExcessiveFailedLoginException(String message) {
        super(message);
    }
}
