package csci2011.plummerlab5;

/**
 *
 * @author chad.plummer
 * CSCI 2011
 * LAB 5
 */
public class FullStackException extends Exception{

    /**
     * Creates a new instance of <code>FullStackException</code> without detail message.
     */
    public FullStackException() {
        super("Full Stack Exception");
    }


    /**
     * Constructs an instance of <code>FullStackException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FullStackException(String msg) {
        super(msg);
    }
}
