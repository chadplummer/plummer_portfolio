package csci2011.plummerlab5;

/**
 *
 * @author chad.plummer
 * CSCI 2011
 * Lab 5
 */
public class EmptyStackException extends Exception {

    /**
     * Creates a new instance of <code>EmptyStackException</code> without detail message.
     */
    public EmptyStackException() {
        super("Empty Stack Exception");
    }


    /**
     * Constructs an instance of <code>EmptyStackException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyStackException(String msg) {
        super(msg);
    }
}
