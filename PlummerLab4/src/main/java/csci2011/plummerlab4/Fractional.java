package csci2011.plummerlab4;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * Fractional extends the Number class and contains the method headers to get the reciprocal of a Fractional object
 * and has the method header to divide
 */
public abstract class Fractional extends Number {
    
    public abstract Fractional reciprocal();
    /**
     * Reciprocal flips the numerator and denominator
     * @param otherNumber
     * @return new Fractional(denominator, numerator) 
     */
    public abstract Number divide(Fractional otherNumber);
    //divides the two numbers by calling multiply and then reciprocal function on the otherNumber
}