package csci2010.plummerprogram2;
import java.util.Scanner;
/**
 *
 * @author chad.plummer
 * CSCI 2010
 * Programming Assignment 2
 * The main class of PlummerProgram uses three 1 method within a while loop. The while loop is present to validate that
 * the user wants to continue.
 * The first method called is chooseTask() which calls 2 separate methods based on user input
 * If the user selects E then it calls encryptTask(), if the user selects D it calls the decryptTask() method
 */
public class PlummerProgram2 {

    public static void main(String[] args) {
       
        String continueMain = "y";
        while(continueMain.compareToIgnoreCase("y") == 0){
            chooseTask();
            Scanner input = new Scanner(System.in);
            System.out.print("Do you want to continue? Y/N ");
            continueMain = input.nextLine();
            if(continueMain.compareToIgnoreCase("N") == 0){
                System.out.println();
                System.out.println("Thanks for using Chad Plummer's cipher program.");
            }
            System.out.println();
        } 
    }
/**
 * encryptTask() asks the user to choose between Shift or Vigenere Cipher then asks for a key or keyword based on their
 * response. Plaintext is retrieved and then a Cipher object is created and the encrypt() method is called. 
 */
public static void encryptTask(){
    Scanner input = new Scanner(System.in);
    System.out.print("Do you want to use a [S]hift Cipher or a [V]igenere Cipher? ");
    String task = input.nextLine();
    if(task.compareToIgnoreCase("S") == 0){
        System.out.print("Please enter a number between 0 and 25 to use as a key: ");
        int key = input.nextInt();
        input.nextLine();
        System.out.print("Please enter the plaintext to be encrypted: ");
        String plainText = input.nextLine();
        Cipher shift = new ShiftCipher(key);
        System.out.println("The corresponding ciphertext is: " + shift.encrypt(plainText));
        
    }
    else if(task.compareToIgnoreCase("V") == 0){
        System.out.print("Please enter a keyword: ");
        String keyword = input.nextLine();
        System.out.print("Please enter the plaintext to be encrypted: ");
        String plainText = input.nextLine();
        Cipher vigenere = new VigenereCipher(keyword);
        System.out.println("The corresponding ciphertext is: " + vigenere.encrypt(plainText));
        
    }
    else{
        System.out.println("Error, please input S or V.");
        System.exit(0);
    }
}
/**
 * decryptTask() asks the user if they want to use shift or vigenere. Based on their response thye give either a 
 * key or keyword and the ciphertext. A Cipher object is made and the decrypt() method is called on the ciphertext.
 */
    public static void decryptTask(){
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to use a [S]hift Cipher or a [V]igenere Cipher? ");
        String task = input.nextLine();
        if(task.compareToIgnoreCase("S") == 0){
            System.out.print("Please enter a number between 0 and 25 to use as a key: ");
            int key = input.nextInt();
            input.nextLine();
            System.out.print("Please enter the plaintext to be decrypted: ");
            String cipherText = input.nextLine();
            Cipher shift = new ShiftCipher(key);
            System.out.println("The corresponding plaintext is: " + shift.decrypt(cipherText));
        }
        else if(task.compareToIgnoreCase("V") == 0){
            System.out.print("Please enter a keyword: ");
            String keyword = input.nextLine();
            System.out.print("Please enter the plaintext to be decrypted: ");
            String cipherText = input.nextLine();
            Cipher vigenere = new VigenereCipher(keyword);
            System.out.println("The corresponding plaintext is: " + vigenere.decrypt(cipherText));
        }
        else{
            System.out.println("Error, please input S or V");
            System.exit(0);
        }
    }
    /**
     * chooseTask() asks the user if they'd like to encrypt or decrypt and then calls the relevant methods for their 
     * response. E = encryptTask() and D = decryptTask().
     */
    public static void chooseTask(){
        System.out.println("Welcome to Chad Plummer's cipher program!");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String task;
        System.out.print("Do you want to [E]ncrypt or [D]ecrypt? ");
        task = input.nextLine();
        if(task.compareToIgnoreCase("E") == 0){
            encryptTask();
        }
        else if(task.compareToIgnoreCase("D") == 0){
            decryptTask();
        }
    }

//END OF FILE
}
