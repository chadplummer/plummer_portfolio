package csci2011.plummerlab8;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
/**
 *
 * @author chad.plummer
 * The main class has the following methods:
 * addContact - this method takes an existing contact and adds it to the file contacts.dat
 * findContact - this method takes a name as a string and opens up contacts.dat to search for the proper contact. If it finds
 *      it the name then it will print out the contact and their number
 * updateContact - this method takes a name as a string parameter and reads contacts.dat to search for a contact with
 *     the same name. If it finds it then it prompts the user for a new phone number and adjusts the contact to have 
 *     the new number.
 * deleteContact - this method takes a name as a string parameter and reads contacts.dat to search for the contact. If
 *      it finds the contact then it will rewrite all of the contacts with the exception of the one being deleted.
 * displayMenu - this method shows the menu
 * getChoice - this method uses a while loop to call display menu. If a choice other than 5 is chosen then it will call
 *      the associated function. If 5 is selected then it will exit the program.
 */
public class PlummerLab8 {

    public static void main(String[] args) {
        getChoice();
    }
    public static void addContact(Contact contact){
        String fileName = "contacts.dat";
        File f = new File(fileName);
        
        if(f.length() == 0){
            Contact[] contactList = new Contact[1];
            try{
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                contactList[0] = contact;
                outputStream.writeObject(contactList);
                outputStream.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        else{
            Contact[] inputList = null;
            try{
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
                inputList = (Contact[])inputStream.readObject();
                inputStream.close();
                Contact[] contactList = new Contact[inputList.length + 1];
                try{
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
                    for(int i = 0; i < inputList.length; i++){
                        contactList[i] = inputList[i];
                    }
                    contactList[inputList.length] = contact;
                    outputStream.writeObject(contactList);
                    outputStream.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
    
    public static void findContact(String contactName){
        Contact[] inputList = null;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("contacts.dat"));
            inputList = (Contact[])inputStream.readObject();
            inputStream.close();
            for(int i = 0; i < inputList.length; i++){
                if(inputList[i].getName().equalsIgnoreCase(contactName)){
                    System.out.println("Contact Found: " + inputList[i].toString());
                    return;
                }
            }
            System.out.println("Contact not found");
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static void updateContact(String name){
        Contact[] inputList = null;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("contacts.dat"));
            inputList = (Contact[])inputStream.readObject();
            inputStream.close();
            //boolean contact = false;
            for(int i = 0; i < inputList.length; i++){
                if(inputList[i].getName().equalsIgnoreCase(name)){
                    //contact = true;
                    
                    Scanner input = new Scanner(System.in);
                    System.out.println("Contact found, please input new phone number: ");
                    String number = input.nextLine();
                    //input.close();
                    Contact newContact = new Contact(name, number);
                    inputList[i] = newContact;
                    Contact[] contactList = new Contact[inputList.length];
                    try{
                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("contacts.dat"));
                        for(int j = 0; j < contactList.length; j++){
                            contactList[j] = inputList[j];
                        }
                        outputStream.writeObject(contactList);
                        System.out.println("Successfully updated the phone number for " + name + " to " + number);
                        outputStream.close();
                        return;
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println("Contact Not Found");
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static void deleteContact(String name){
        Contact[] inputList = null;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("contacts.dat"));
            inputList = (Contact[])inputStream.readObject();
            inputStream.close();
            for(int i = 0; i < inputList.length; i++){
                if(inputList[i].getName().equalsIgnoreCase(name)){
                    Contact[] contactList = new Contact[inputList.length-1];
                    try{
                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("contacts.dat"));
                        int counter = 0;
                        for(int j = 0; j < contactList.length; j++){
                            if(inputList[counter].getName().equalsIgnoreCase(name)){
                                counter++;
                            }
                            contactList[j] = inputList[counter];
                            counter++;
                        }
                        outputStream.writeObject(contactList);
                        outputStream.close();
                        System.out.println("Successfully deleted Contact: " + name);
                        return;
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }
            }        
        System.out.println("Contact not found with the name: " + name);
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static void displayMenu(){
        System.out.println("Welcome to Chad Plummer's Contact Binary file editor");
        System.out.println();
        System.out.println("Type in your choice from the options below");
        System.out.println("Press 1 to add a contact");
        System.out.println("Press 2 to find a contact");
        System.out.println("Press 3 to update a contact");
        System.out.println("Press 4 to delete a contact");
        System.out.println("Press 5 to exit from the application");
    }
    
    public static void getChoice(){
        int choice = 0;
        while(choice != 5){
            displayMenu();
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()){
                choice = input.nextInt();
            }
            if (choice == 1){
                System.out.println("Adding Contact...");
                System.out.println("Input name for the contact:");
                Scanner inputName = new Scanner(System.in);
                String name = inputName.nextLine();
                System.out.println("Input phone number for " + name);
                Scanner inputNumber = new Scanner(System.in);
                String number = inputNumber.nextLine();
                Contact contact = new Contact(name, number);
                addContact(contact);
                System.out.println("Successfully added new Contact info:");
                System.out.println(contact.toString());
            }
            else if (choice == 2){
                System.out.println("Enter the name of the Contact you are searching for: ");
                Scanner inputFind = new Scanner(System.in);
                String name = inputFind.nextLine();
                findContact(name);
            }
            else if (choice == 3){
                System.out.println("Updating contact");
                System.out.println("Enter the name of the contact you'd like to update");
                Scanner inputName = new Scanner(System.in);
                String name = inputName.nextLine();
                //inputName.close();
                updateContact(name);
            }
            else if (choice == 4){
                System.out.println("Deleting Contact");
                System.out.println("Enter the name of the contact you'd like to delete");
                Scanner inputName = new Scanner(System.in);
                String name = inputName.nextLine();
                deleteContact(name);
            }
            System.out.println();
        }
        System.out.println("Thank you for using Chad Plummer's contacts.dat file manager");
    }
}
