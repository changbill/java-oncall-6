package oncall.exception;

public class InputException extends HandlerException {
    public InputException() {
        super("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
