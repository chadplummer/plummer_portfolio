package csci2011.plummerlab10;

import java.util.ArrayList;

/**
 *
 * @author chad.plummer
 * CSCI 2011 lab 10
 * ArrayListNumberStack creates an ArrayList object of type double and overrides the methods 
 * defined in the NumberStack Interface. Push calls add to store a number on the list
 * pop copies the last stored number, deletes it from the list, and returns the number that
 * was removed
 * clear empties the list
 * size gets the size of the list
 * isEmpty checks to see if the list is empty. 
 * contains checks to see if a value is found in the ArrayList
 */
public class ArrayListNumberStack  implements NumberStack {
    private ArrayList<Double> list;
    
    public ArrayListNumberStack(){
        list = new ArrayList<>();
    }
    
    @Override
    public void push(double num){
        list.add(num);
    }
    @Override
    public double pop() throws EmptyStackException{
        if(list.isEmpty()){
            throw new EmptyStackException();
        }
        else{
            double data = list.get(list.size()-1);
            list.remove(list.size()-1);
            return data;
        }
    }
    @Override
    public void clear(){
        list.clear();
    }
    
    @Override
    public int size(){
        return list.size();
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public boolean contains(Double num){
        return list.contains(num);
    }
}
