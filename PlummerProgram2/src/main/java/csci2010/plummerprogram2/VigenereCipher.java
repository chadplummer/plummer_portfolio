package csci2010.plummerprogram2;
/**
 *
 * @author chad.plummer
 * CSCI 2010
 * Programming Assignment 2
 * This extends SubstituteCipher and defines reset() encryptChar() and decryptChar() using the vigenere cipher algorithm
 */
public class VigenereCipher extends SubstitutionCipher {
    private String key;
    private int charIndex;
    VigenereCipher(){
        key = null;
        charIndex = 0;
    }
    //constructor; initializes the key and sets charIndex to zero
    VigenereCipher(String ikey){
        key = ikey;
        charIndex = 0;
    }
    //sets the charIndex back to zero
    @Override
    public void reset(){
        charIndex = 0;
    }
    //takes the plainText char as a parameter, checks that it is a letter, if true then charIndex++
    //if the charIndex is equal to the length of the key it calls reset()
    //calls getKeyNum to get the key number for the char
    //calls the base shiftchar() using the plainChar and kuyNum to swap the char to its encrypted form
    @Override
    public char encryptChar(char plainChar){
            char encryptedLetter = key.charAt(charIndex);
            if (alphabetic(plainChar)){
                charIndex++;
            }
            if (charIndex == key.length()){
                reset();
            }
            int keyNum = getKeyNum(encryptedLetter);
            if ( keyNum < 0){
                return plainChar;
            }
            else{
                return super.shiftChar(plainChar, keyNum);
            }
    }
    //takes the cipherText char as a parameter, checks that it is a letter, if true then charIndex++
    //if the charIndex is equal to the length of the key it calls reset()
    //calls getKeyNum to get the key number for the char
    //calls the base shiftchar() using the cipherChar and kuyNum to swap the char to its decrypted form
    @Override
    public char decryptChar(char cipherChar){
        char encryptedLetter = key.charAt(charIndex);
        if(alphabetic(cipherChar)){
            charIndex++;
        }
        if(charIndex == key.length()){
            reset();
        }
        int keyNum = getKeyNum(encryptedLetter);
        if(keyNum < 0){
            return cipherChar;
        }
        else{
            return super.shiftChar(cipherChar, (26 - keyNum));
        }
    }
    
}
