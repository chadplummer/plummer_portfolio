package csci2010.plummerprogram2;
/**
 *
 * @author chad.plummer
 * CSCI 2010
 * Programming Assignment 2
 * This is a derived class of SubstitutionCipher and defines reset() encryptChar() and decryptChar() as well as its
 * constructor.
 */
public class ShiftCipher extends SubstitutionCipher{
    private int key;
    ShiftCipher(){
        key = 0;
    }
    //constructor, sets key to equal user input ikey
    ShiftCipher(int ikey){
        key = ikey;
    }
    //reset does nothing here, so it's overridden for functionality
    @Override
    public void reset(){
        
    }
    //encryptChar calls shiftsChar from the base class using the parameters letter and key
    //it then converts the plaintext char to its encrypted form
    @Override
    public char encryptChar(char letter){
        return super.shiftChar(letter, key);
        }
    //decryptChar calls shiftsChar from the base class using the parameters letter and key
    //it then converts the plaintext char to its decrypted form
    @Override
    public char decryptChar(char letter){
        return super.shiftChar(letter, (26 - key));
    }
}
