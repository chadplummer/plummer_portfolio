package csci2011.plummerlab4;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * Number contains the method headers for a variety of mathematical functions that behave on numbers such as
 * add, subtract, multiply, negate, and divide
 */
public abstract class Number {
    public abstract Number add(Number otherNumber);
    //Adds the two numbers
    public abstract Number negate();
    //converts the number into the inverse of itself (negative to positive and vice versa)
    public abstract Number subtract(Number otherNumber);
    //calls negate on otherNumber then adds "this" and otherNumber
    public abstract Number multiply(Number otherNumber);
    //multiplies the number it's called on with the parameter
}
