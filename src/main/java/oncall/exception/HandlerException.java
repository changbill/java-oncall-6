package oncall.exception;

public class HandlerException extends IllegalArgumentException {
    public HandlerException(String message) {
        super("[ERROR] " + message);
    }
}
