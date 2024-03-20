package csci2011.plummerlab4;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * Rational extends Fractional and implements the interfaces of comparable and convertible
 * Rational creates an object using a constructor to collect a numerator and denominator
 * This class defines the methods whose headers are found in other abstract classes and interfaces
 * These methods include add, subtract, negate, and multiply from Number
 * compareTo from comparable
 * intValue and doubleValue from convertible
 * and reciprocal and divide from Fractional
 * Accesor methods for the numerator and denominator are available as well
 * toString is a method designed to print the numerator and denominator as a fraction.
 */
public class Rational extends Fractional implements Comparable,Convertible {
    private int numerator;
    private int denominator;
    
    public Rational(int iNumerator, int iDenominator){
        if (iDenominator == 0){
            System.out.println("Error, denominator must not be Zero");
            System.exit(0);
        }
        else if (iDenominator < 0){
            numerator = -iNumerator;
            denominator = -iDenominator;
        }
        else{
        numerator = iNumerator;
        denominator = iDenominator;
        }
    }
    @Override
    public Number add(Number otherNumber){
        Rational otherFraction = (Rational)otherNumber;
        return new Rational((this.numerator * otherFraction.denominator + 
                            this.denominator * otherFraction.numerator), 
                            this.denominator * otherFraction.denominator);
    }
    @Override
    public Number subtract(Number otherNumber){
        Rational newFraction = (Rational)otherNumber;
        return this.add(otherNumber.negate());
    }
    @Override
    public Number multiply(Number otherNumber){
        Rational otherFraction = (Rational)otherNumber;
        return new Rational(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);
    }
    @Override
    public Number negate(){
        return new Rational((-numerator), denominator);
    }
    @Override
    public Fractional reciprocal(){
        if (numerator == 0){
            System.out.println("Error, denominator cannot be Zero");
            System.exit(0);
        }
            return new Rational(denominator, numerator);
    }
    @Override
    public int compareTo(Object otherObject){

        if(otherObject != null && otherObject instanceof Rational) {
            Rational otherFraction = (Rational)otherObject;
            return this.numerator * otherFraction.denominator - this.denominator * otherFraction.numerator;
        }
        return -1;
    }
    @Override
    public int intValue(){
        return numerator / denominator;
    }
    @Override
    public double doubleValue(){
        return (double)numerator / (double)denominator;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        return getNumerator() + "/" + getDenominator();
    }
    @Override
    public Number divide(Fractional otherNumber){
        Rational otherFraction = (Rational)otherNumber.reciprocal();
        return this.multiply(otherFraction);
    }
    
}
