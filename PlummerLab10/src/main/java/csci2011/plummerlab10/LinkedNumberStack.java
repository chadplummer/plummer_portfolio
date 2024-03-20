package csci2011.plummerlab10;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @chad.plummer
 * CSCI 2011 Lab 10
 * LinkNumberStack defines the methods found in NumberStack and defines a ListNode
 * Push creates a new ListNode and stores the head Nodes data. The head node is then replaced with
 *      the new data
 * pop copies the data at the head node, makes the head node the next linked node, and then 
 *      returns the data that was just removed.
 * isEmpty checks to see if head == null.
 * clear changes the head node to = null and resets sizeOfList to 0
 * size returns the sizeOfList
 * getData is a custom method I added to check and if my data is being added to the list
 *      it essentially prints off all data found within the LinkList until it reaches null.
 */
public class LinkedNumberStack implements NumberStack {
    public class ListNode{
        private double data;
        private ListNode next;
        
        public ListNode(double newData, ListNode newNode){
            data = newData;
            next = newNode;
        }
    }
    ListNode head;
    int sizeOfList;
    
    public LinkedNumberStack(){
        head = null;
        sizeOfList = 0;
    }
    @Override
    public void push(double newData){
        
        if(this.head == null){
            ListNode newNode = new ListNode(newData, null);
            head = newNode;
            sizeOfList++;
        }
        else{
            ListNode current = head;
            ListNode newNode = new ListNode(newData, current);
            head = newNode;
            sizeOfList++;
        }
    }
    @Override
    public double pop() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        else{
            double headData = head.data;
            head = head.next;
            sizeOfList--;
            return headData;
        }  
    }
    @Override
    public void clear(){
        head = null;
        sizeOfList = 0;
    }
    @Override
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int size(){
        return sizeOfList;
    }
    public void getData(){
        ListNode current = head;
        if(this.isEmpty()){
            System.out.println("Error, list is empty");
        }
        else{
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
                if(current == null){
                    System.out.println();
                }
            }
        }
    }
}
