package csci2011.plummerlab5;
/**
 *
 * @author chad.plummer
 * CSCI 2011
 * LAB 5
 * 
 * The NumberStack class initializes an array of doubles and defines methods for adding to the array and 
 * deleting numbers from the array. 
 * Aside from the Constructor the following methods have been added: 
 * toString() isEmpty() isFull() push() pop() getArray() and getArraySize()
 * 
 * push() checks for FullStackException and pop() checks for EmptyStackException
 */
public class NumberStack {
    private double[] doubleArray;
    private int arraySize;
    private int numbers;
    
    /**
     * 
     * @param iSize 
     * Constructor for NumberStack, takes iSize as a parameter and sets that to the maximum size of the array
     * sets the total numbers in the array to 0
     */
    public NumberStack(int iSize){
        arraySize = iSize;
        doubleArray = new double[arraySize];
        numbers = 0;
    }
    //Object method toString has been overridden to simply return empty stack
    @Override
    public String toString(){
            return "empty stack";
    }
    /**
     * isEmpty checks if the total numbers in the array is 0, if true it returns true
     * else returns false
     * 
     */
    public boolean isEmpty(){
        if(numbers == 0){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * isFull is a boolean method that checks to see if numbers == arraySize. If it returns true
     * then that means the array is full, false means the array is not full
     *  
     */
    public boolean isFull(){
        if(numbers == arraySize){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * push takes a double as a parameter and tries to add that to the array.
     * it first calls a try block that calls the ifFull() method. If true then it returns a FullStackException
     * to be caught by catch.
     * Otherwise, it adds the number to the end of the array and increments number by one
     * 
     */
    public void push(double number){
        try{
            if (isFull() == true){
//Original throw code directly below as a comment
                //throw new Exception("Exception: Array is full cannot add " + number);
                throw new FullStackException();
            }
            else{
                doubleArray[numbers] = number;
                numbers++;
            }

        }
//Original catch code directly below as a comment
        //catch(Exception e){
        catch(FullStackException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * The purpose of the pop() method is to decrease the number of values in the array by one.
     * First it calls on a try block and calls the isEmpty() method. If true then a EmptyStackException is caught
     * by catch, displaying the error message. 
     * Otherwise, number is decremented by one.
     *  
     * pop() was set up to return a double because the instructions said to use the decremented number
     * to act as an index to return the last number in the array
     */
    public void pop(){
        try{
            if(isEmpty() == true){
//Original throw code directly below as a comment
                //throw new Exception("Exception: Stack is empty, cannot be removed");
                throw new EmptyStackException();
            }
        }
//Original catch code directly below as a comment
        //catch(Exception e){
        catch(EmptyStackException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        numbers--;
    }
    //getArray is the accessor method for a value within the array
    public double getArray(){
        if (numbers == 0){
            return 0.0;
        }
            return doubleArray[numbers - 1];
    }
    //getArrayMaxSize() is the accessor method for the arraySize
    public int getArrayMaxSize(){
        return arraySize;
    }
    public int getNumbers(){
        return numbers;
    }
}
