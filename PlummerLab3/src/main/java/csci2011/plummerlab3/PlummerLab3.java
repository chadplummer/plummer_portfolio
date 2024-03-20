package csci2011.plummerlab3;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 3
 * The main class file serves to test the methods within Polygon, RegularPolygon, and RegularTriangle
 */
public class PlummerLab3 {

    public static void main(String[] args) {
        //Polygon constructor test
        System.out.println("Testing Polygon constructor:");
        Polygon test = new Polygon(4);
        System.out.println(test.toString());
        
        //Regular Polygon constructor test
        System.out.println("Testing Regular Polygon constructor:");
        RegularPolygon test2 = new RegularPolygon(5, 1);
        System.out.println(test2.toString());
    
        //Regular Polygon Mutator test
        System.out.println("Testing Regular Polygon mutator:");
        test2.setLength(2.0);
        System.out.println(test2.toString());
        
        //Regular Triangle constructor test
        System.out.println("Testing Regular Triangle constructor: ");
        RegularTriangle test3 = new RegularTriangle(4.0);
        System.out.println(test3.toString());
        
        //R. Triangle height mutator test
        System.out.println("Testing Regular Triangle Height Mutator: ");
        test3.setHeight(3.0);
        System.out.println(test3.toString());
        
        //R. Triangle side length mutator test
        System.out.println("Testing Regular Triangle Side Length Mutator: ");
        test3.setLength(4.0);
        System.out.println(test3.toString());
    }
}
