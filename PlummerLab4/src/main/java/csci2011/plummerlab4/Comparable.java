package csci2011.plummerlab4;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 4
 * Comparable.java is the interface that's used within the lab package to access the compareTo method.
 * 
 */

public interface Comparable {
    public int compareTo(Object otherObject);
    /**
     * this method compares the object it was called on to the parameter passed into the method.
     * if a/b < c/d then ad < bc, so ad - bc < 0
     * if a/b = c/d then ad = bc, so ad - bc = 0
     * if a/b > c/d then ad > bc, so ad - bc > 0
     */
}