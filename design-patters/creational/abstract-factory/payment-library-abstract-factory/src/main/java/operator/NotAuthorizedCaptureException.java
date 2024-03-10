package operator;

public class NotAuthorizedCaptureException extends RuntimeException {

    public NotAuthorizedCaptureException(String message) {
        super(message);
    }
}
