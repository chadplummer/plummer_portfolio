package csci2011.plummerlab4;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * PlummerLab4 is the main class file. Its intended purpose is to test out the various methods defined in 
 * Rational.
 */
public class PlummerLab4 {

    public static void main(String[] args) {
        //Testing the constructor for Rational
        Rational number = new Rational(3, 4);
        //Testing toString and the accesor methods for numerator and denominator
        System.out.println("Numerator = " + number.getNumerator() + " and Denominator = " + number.getDenominator());
        System.out.println("toString Returns: " + number.toString());
        System.out.println();
        //Testing the constructor for when a negative denominator is given
        Rational number2 = new Rational(4, -5);
        System.out.println("Numerator = " + number2.getNumerator() + " and Denominator = " + number2.getDenominator());
        System.out.println("toString Returns: " + number2.toString());
        System.out.println();
        //Testing the negate(), reciprocal(), intValue(), and doubleValue() methods
        System.out.println("Negation of " + number.toString() + " is: " + number.negate().toString());
        System.out.println("Reciprocal of " + number.toString() + " is: " + number.reciprocal().toString());
        System.out.println("Integer value of " + number.toString() + " is: " + number.intValue());
        System.out.println("Double value of " + number.toString() + " is: " + number.doubleValue());
        System.out.println();
        //Testing the add(), subtract(), multiply(), and divide() methods
        System.out.println(number.toString() + " + " + number2.toString() + " = " + number.add(number2));
        System.out.println(number.toString() + " - " + number2.toString() + " = " + number.subtract(number2));
        System.out.println(number.toString() + " * " + number2.toString() + " = " + number.multiply(number2));
        System.out.println(number.toString() + " / " + number2.toString() + " = " + number.divide(number2));
    }
}
