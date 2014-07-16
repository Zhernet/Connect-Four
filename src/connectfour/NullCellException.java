package connectfour;

public class NullCellException extends RuntimeException {

    public NullCellException() {
    }

    public NullCellException(String msg) {
        super(msg);
    }
}
