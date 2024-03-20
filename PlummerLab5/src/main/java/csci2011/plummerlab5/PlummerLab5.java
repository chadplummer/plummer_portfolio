package csci2011.plummerlab5;

/**
 *
 * @author chad.plummer
 * CSCI 2011
 * LAB 5
 * 
 * The main class serves as the Test file for the class NumberStack
 * More information on Numberstack can be found within that file
 */
public class PlummerLab5 {

    public static void main(String[] args) {
        //initilizing the NumberStack constructor
        NumberStack stack = new NumberStack(3); 
        
        System.out.println("Maximum size of doubleArray[]: " + stack.getArrayMaxSize());
        System.out.println();
        //Testing toString()
        System.out.println("Testing toString() on empty array");
        System.out.println(stack.toString());
        System.out.println();
        //Testing push()
        System.out.println("Testing push()");
        stack.push(3.0);
        System.out.println("doubleArray[0] = " + stack.getArray());
        stack.push(4.0);
        System.out.println("doubleArray[1] = " + stack.getArray());
        stack.push(5.0);
        System.out.println("doubleArray[2] = " + stack.getArray());
        
        //Pcalling push() to test FullStackException
        stack.push(6.0);
        System.out.println();
        
        //testing pop() 3 times and then testing pop() for EmptyStackException
        System.out.println("Testing pop():");
        System.out.println("Last number in the array before running pop(): " + stack.getArray());
        System.out.println("Total number of items within the array before running pop(): " + stack.getNumbers());
        System.out.println();
        
        testPop(stack);
        testPop(stack);
        testPop(stack);
        testPop(stack);
        
    }
    
    public static void testPop(NumberStack stack){
        System.out.println("Running pop()");
        System.out.println("Total number of items in the array before pop(): " + stack.getNumbers());
        stack.pop();
        System.out.println("Total number of items in the array after pop(): " + stack.getNumbers());
        if(stack.getArray() == 0.0){
            System.out.println("There is nothing in the array");
            System.out.println();
        }
        else{
            System.out.println("Last number in the array: " + stack.getArray());
            System.out.println();
        }
    }
}
