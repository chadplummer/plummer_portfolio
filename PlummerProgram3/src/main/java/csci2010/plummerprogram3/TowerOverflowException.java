package csci2010.plummerprogram3;

/**
 *
 * @author $chad.plummer
 * This is the TowerOverflowException. It has a very basic message that was used for testing purposes.
 */
public class TowerOverflowException extends Exception {

    /**
     * Creates a new instance of <code>TowerOverflowException</code> without detail message.
     */
    public TowerOverflowException() {
        super("Tower OverFlow Exception");
    }


    /**
     * Constructs an instance of <code>TowerOverflowException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TowerOverflowException(String msg) {
        super(msg);
    }
}
