package csci2011.plummerlab3;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 3
 * This class is a subclass of Polygon. It sets calls the constructor of Polygon for the number of sides
 * then sets the side length to a double taken as a parameter. It then calculates the perimeter using the 
 * numberOfSides and the sideLength. toString is overridden from Polygon to display all information about
 * the object
 */
public class RegularPolygon extends Polygon{
    
    private double lengthOfSides;
    public RegularPolygon(){
    super();
    lengthOfSides = 0;
    }
    //Constructor for the class
    public RegularPolygon(int sides, double length){
        super(sides);
        setLength(length);
    }
    //Mutator for the side length
    public void setLength(double length){
        if(length <= 0){
            System.out.println("Error, please input a value greater than 0 for the length.");
            System.out.println();
            return;
        }
        else{
            lengthOfSides = length;
        }
    }
    //accessor for the side length of the class
    public double getLength(){
        return lengthOfSides;
    }
    //this both solves for the perimeter as well as serves as an accessor method
    public double getPerimeter(){
        double perimeter = getLength() * getSides();
        return perimeter;
    }
    //this overrides the toString method from polygon and then calls that same method to display info about the
    //class
    @Override
    public String toString(){
        String length = "Side length " + getLength();
        String perimeter = "Perimeter: " + getPerimeter();
        return super.toString() + length + "\n" + perimeter + "\n";
        
    }
}
