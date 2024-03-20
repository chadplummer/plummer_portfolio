package csci2010.plummerprogram3;

/**
 *
 * @author $chad.plummer
 * This is the IllegalPushException. It has a very basic message that was used for testing purposes.
 */
public class IllegalPushException extends Exception {

    /**
     * Creates a new instance of <code>IllegalPushException</code> without detail message.
     */
    public IllegalPushException() {
        super("Illegal Push Exception");
    }


    /**
     * Constructs an instance of <code>IllegalPushException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IllegalPushException(String msg) {
        super(msg);
    }
}
