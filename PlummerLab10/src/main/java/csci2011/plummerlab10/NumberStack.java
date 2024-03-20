package csci2011.plummerlab10;
/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 10
 * This interface houses the methods that will be used in ArrayListNumberStack and 
 * LinkedListNumberStack
 * 
 */
public interface NumberStack{
    public double pop() throws EmptyStackException;
    public void push(double num);
    public boolean isEmpty();
    public int size();
    public void clear();
}