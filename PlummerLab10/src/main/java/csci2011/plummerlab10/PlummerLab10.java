package csci2011.plummerlab10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author chad.plummer
 * CSCI 2011 lab 10
 * The main class runs tests for the LinkedNumberStack and the ArrayListNumberStack classes
 * as well as the methods doOperation and evaluateRPN
 * doOperation takes a NumberStack object and a string as an operator and does the
 * proper mathematical operation. The resulting number is pushed onto the stack in place of 
 * the two numbers that originally were on the stack.
 * 
 * evaluateRPN takes a NumberStack object and a String RPN as parameters. It then reads the 
 * RPN and stores the numbers on the NumberStack and calls doOperation using the NumberStack and
 * the operators it encounters.
 */
public class PlummerLab10 {

    public static void main(String[] args) throws EmptyStackException, UnsupportedOperationException {
        System.out.println("Testing push on ArrayListNumberStack");
        ArrayListNumberStack list = new ArrayListNumberStack();
        list.push(10);
        System.out.println("Successfully pushed 10 onto ArrayListNumberStack");
        System.out.println();
        double num = 10;
        System.out.println("Does " + num + " exist in the ArrayList? ");
        System.out.println(list.contains(num));
        System.out.println("Size of the ArrayList");
        System.out.println(list.size());
        System.out.println("Pushing 11, 12, 13");
        list.push(11);
        list.push(12);
        list.push(13);
        System.out.println("Current size of Array list: " + list.size());
        System.out.println("Testing pop() and displaying size of the array after");
        list.pop();
        System.out.println(list.size());
        list.clear();
        System.out.println();
        
        System.out.println();
        System.out.println("testing LinkedNumberStack");
        LinkedNumberStack linkList = new LinkedNumberStack();
        System.out.println("LinkedList created");
        linkList.push(10.0);
        System.out.println("Successfully added 10");
        linkList.push(11.0);
        System.out.println("Successfully added 11");
        
        linkList.push(12.0);
        System.out.println("Successfully added 12");
        System.out.println("Printing list: ");
        linkList.getData();
        System.out.print("Size of linkList: ");
        System.out.println(linkList.size());
        System.out.print("Testing pop, number removed: ");
        System.out.println(linkList.pop());
        System.out.print("linkList values: ");
        linkList.getData();
        System.out.print("Size of linkList: ");
        System.out.println(linkList.size());
        System.out.println("Testing clear");
        linkList.clear();
        System.out.println("Size of list now: " + linkList.size());
        System.out.println("Printing list:");
        linkList.getData();
        System.out.println();
        
        System.out.println("Adding the following values to the LinkedNumberStack: 10, 11, 12, 13, 14, 15");
        linkList.push(10);
        linkList.push(11);
        linkList.push(12);
        linkList.push(13);
        linkList.push(14);
        linkList.push(15);
        System.out.print("Displaying new LinkList values: ");
        linkList.getData();
        System.out.println("Testing doOperation with doOperation(linkList, +)");
        doOperation(linkList, "+");
        linkList.getData();
        System.out.println();
        linkList.clear();
        
        System.out.println("Testing RPN with LinkedNumberStack");
        evaluateRPN(linkList, "23 21 +");
        evaluateRPN(linkList, "11 78 73 - *");
        evaluateRPN(linkList, "8 +");
        evaluateRPN(linkList, "7 2 %");
        
        System.out.println("Testing RPN with ArrayListNumberStack");
        evaluateRPN(list, "23 21 +");
        evaluateRPN(list, "11 78 73 - *");
        evaluateRPN(list, "8 +");
        evaluateRPN(list, "7 2 %");
    }
    
    public static void doOperation(NumberStack stack, String  operator) throws EmptyStackException, UnsupportedOperationException {
        double numOne = stack.pop();
        double numTwo = stack.pop();
        
        if(operator.equalsIgnoreCase("+")){
            double result = numTwo + numOne;
            stack.push(result);
        }
        else if(operator.equalsIgnoreCase("-")){
            double result = numTwo - numOne;
            stack.push(result);
        }
        else if(operator.equalsIgnoreCase("*")){
            double result = numTwo * numOne;
            stack.push(result);
        }
        else if(operator.equalsIgnoreCase("/")){
            double result = numTwo / numOne;
            stack.push(result);
        }
        else{
            stack.push(numTwo);
            stack.push(numOne);
            throw new UnsupportedOperationException();
        }
    }
    
    public static void evaluateRPN(NumberStack stack, String expression){
        System.out.println("input: " + expression);
        Scanner input = new Scanner(expression);
        try{
            while(input.hasNext()){
                if(input.hasNextDouble()){
                    double num = input.nextDouble();
                    stack.push(num);
                }
                else{
                    String operator = input.next();
                    doOperation(stack, operator);
                }
            }
            System.out.println("Result: " + stack.pop());
            
            
        }catch(EmptyStackException | UnsupportedOperationException e){
            if(e.getMessage().equalsIgnoreCase("EmptyStackException")){
                System.out.println("Too few Operands");
            }
            else{
                System.out.println("Unsupported Operation");
            }
            
        }
        finally{
            stack.clear();
            System.out.println();
        }
    }
}