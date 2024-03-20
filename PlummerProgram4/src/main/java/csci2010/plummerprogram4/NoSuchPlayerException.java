package csci2010.plummerprogram4;

/**
 *
 * @author $chad.plummer
 */
public class NoSuchPlayerException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchPlayerException</code> without detail message.
     */
    public NoSuchPlayerException() {
        super("There is no player named ");
    }


    /**
     * Constructs an instance of <code>NoSuchPlayerException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NoSuchPlayerException(String msg) {
        super(msg);
    }
}
