package csci2011.plummerlab3;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 3
 * Polygon serves as the parent class for both RegularPolygon and Triangle
 * It sets the numberOfSides for a Polygon object and display this info using toString
 */
//This is the parent class for both RegularPolygon and Regular Triangle
public class Polygon {
    private int numberOfSides;
    public Polygon(){
        numberOfSides = 0;
    }
    
    //constructor that uses the initialize() method to set the #of sides so that super(); works
    public Polygon(int sides){
        initialize(sides);
    }
    //This is the initializer that set the sides and checks for error
    public void initialize(int sides){
        if(sides < 3){
            System.out.println("Error, numer of sides must be greater than or equal to 3.");
            System.out.println();
            return;
        }
        else{
            numberOfSides = sides;
        }
    }
    //accessor method for numberOfSides
    public int getSides(){
        return numberOfSides;
    }

    //toString from Object class is overwritten to present the number of sides of the Polygon Class
    @Override
    public String toString(){
        return "Number of Sides: " + getSides() + "\n";
    }
}
