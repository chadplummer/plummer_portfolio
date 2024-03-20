package csci2011.plummerlab3;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 3
 * Polygon > RegularPolygon > RegularTriangle
 * RegularTriangle serves as a more specific object that is a subclass of RegularPolygon.
 * It uses methods with Polygon and RegularPolygon to set the numberOfSides and the sideLength then
 * calculates the side height and the area of the RegularTriangle Object. toString is overridden to 
 * call the same function to display all of the information.
 */
public class RegularTriangle extends RegularPolygon{
    private double triangleHeight;
    
    //Constructor for RegularTriangle uses double as parameter to set the length via RegularPolygon Constructor
    //Additionally sets numberOfSides to 3 because... it's a triangle
    public RegularTriangle(double length){
        super(3, length);
    }
    //Overridden setLength method from RegularPolygon, calls setlength from RegularPolygon and sets triangleHeight
    //using math equation
    @Override
    public void setLength(double length){
        super.setLength(length);
        triangleHeight = Math.sqrt(3.0) * length / 2.0;
    }
    //accessor method for triangleHeight
    public double getHeight(){
        return triangleHeight;
    }
    //Mutator method for triangleHeight. Provides error check if value is <=0
    public void setHeight(double height){
        if (height <= 0){
            System.out.println("Error, value must be greater than 0");
            System.exit(0);
        }
        triangleHeight = height;
        setLength(2.0 * height/Math.sqrt(3.0));
    }
    //This both calculates the area and serves as an accessor for the area of the object
    public double getArea(){
        double area = 0.5 * getLength()* triangleHeight;
        return area;
    }
    //Overridden toString method calls toString from parent class RegularPolygon and displays new info, 
    //Area and Height
    @Override
    public String toString(){
        return super.toString() + 
                "Height: " + getHeight() + "\n" + 
                "Area: " + getArea() +  "\n";
    }
}
