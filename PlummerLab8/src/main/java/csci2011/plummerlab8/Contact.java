package csci2011.plummerlab8;
import java.io.Serializable;
/**
 * 
 * @author chad.plummer
 * This class implements serializable in order to be used in a binary file. It has a simple constructor
 * to build the name and phone number for the object. getName is used as the accessor method for name. 
 * toString has been Overridden to return to print the Contact info.
 */
public class Contact implements Serializable{
        String name;
        String phone;
        
        public Contact(){
            name = null;
            phone = null;
        }
        public Contact(String iName, String iPhone){
            name = iName;
            phone = iPhone;
        }
        @Override
        public String toString(){
            return ("Name: " + name + " Phone Number: " + phone);
        }
        public String getName(){
            return name;
        }
    }
