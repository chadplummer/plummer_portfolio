package csci2010.plummerprogram3;

/**
 *
 * @author $chad.plummer
 * This is the EmptyTowerException. It has a very basic message that was used for testing purposes.
 */
public class EmptyTowerException extends Exception {

    /**
     * Creates a new instance of <code>EmptyTowerException</code> without detail message.
     */
    public EmptyTowerException() {
        super("Empty Tower Exception");
    }


    /**
     * Constructs an instance of <code>EmptyTowerException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyTowerException(String msg) {
        super(msg);
    }
}
