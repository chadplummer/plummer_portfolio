package csci2010.plummerprogram2;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author chad.plummer
 * CSCI 2010
 * Programming assignment 2
 * SubstitutionCipher implements Cipher and abstracts the encryptChar, decryptChar, and reset methods for VigenereCipher
 * and ShiftCipher classes. getKeyNum, alphabetic, and shiftChar are defined here. Encrypt() and Decrypt()
 * are overridden from Cipher here as well.
 */
public abstract class SubstitutionCipher implements Cipher{
    public abstract char encryptChar(char plainChar);
    public abstract char decryptChar(char cipherChar);
    public abstract void reset();
    
    //Checks to make sure the char passed to it is a letter or not and returns true or false
    public static boolean alphabetic(char letter){
        return Character.isLetter(letter);          
    }
    //if the parameter is a letter getKeyNum returns the corresponding number to letter - 'A' or 'a'
    public static int getKeyNum(char letter){
        if(alphabetic(letter) == false){
            return -1;
    }
        else{
            if (Character.isUpperCase(letter)){
                return letter - 'A';
            }
            else{
                return letter - 'a';
            }
        }
    }
    //shiftChar returns the result of shifting the letter by the corresponding key
    public static char shiftChar(char letter, int key){
        if (Character.isUpperCase(letter)){
            return (char)((letter - 'A' + key) % 26 + 'A');
        }
        else if (Character.isLowerCase(letter)){
            return (char)((letter - 'a' + key) % 26 + 'a');
        }
        else
            return letter;
    }
    //encrypt() converts plaintext using encrptChar() and stores it to the ciphertext and returns it
    @Override
    public String encrypt(String plainText){
        reset();
        String cipherText = StringUtils.EMPTY;
        for(int i = 0; i < plainText.length(); i++){
            char result = encryptChar(plainText.charAt(i));
            cipherText = cipherText + result;
        }
        return cipherText;   
    }
    //decrypt() converts ciphertext using decryptChar() and stores it to plainText and returns it
    @Override
    public String decrypt(String cipherText){
        reset();
        String plainText = StringUtils.EMPTY;
        for(int i = 0; i < cipherText.length(); i++){
            plainText = plainText + decryptChar(cipherText.charAt(i));
        }
        return plainText;
    }
    
}
