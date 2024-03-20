package csci2011.plummerlab4;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * Convertible is the interface to access the methods that convert the later objects (Rational and Fractional)
 * and convert them into integers (intValue) and doubles (doubleValue).
 */

public interface Convertible {
    public int intValue();
    //converts the object into its integer form
    public double doubleValue();
    //converts the object into its decimal form
    
}