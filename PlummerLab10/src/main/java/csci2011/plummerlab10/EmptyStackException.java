package csci2011.plummerlab10;

/**
 *
 * @author $chad.plummer
 */
public class EmptyStackException extends Exception {

    /**
     * Creates a new instance of <code>EmptyStackException</code> without detail message.
     */
    public EmptyStackException() {
        super("EmptyStackException");
    }


    /**
     * Constructs an instance of <code>EmptyStackException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyStackException(String msg) {
        super(msg);
    }
}
