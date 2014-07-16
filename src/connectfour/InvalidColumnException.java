package connectfour;

public class InvalidColumnException extends RuntimeException {

    public InvalidColumnException() {
    }
    
    public InvalidColumnException(String msg) {
        super(msg);
    }
}
