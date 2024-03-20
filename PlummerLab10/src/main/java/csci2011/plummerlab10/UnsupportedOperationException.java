package csci2011.plummerlab10;

/**
 *
 * @author $chad.plummer
 */
public class UnsupportedOperationException extends Exception {

    /**
     * Creates a new instance of <code>UnsupportedOperationException</code> without detail message.
     */
    public UnsupportedOperationException() {
        super("UnsupportedOperationException");
    }


    /**
     * Constructs an instance of <code>UnsupportedOperationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public UnsupportedOperationException(String msg) {
        super(msg);
    }
}
