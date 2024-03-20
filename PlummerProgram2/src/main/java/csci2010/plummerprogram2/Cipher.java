package csci2010.plummerprogram2;
/**
 * 
 * @author chad.plummer
 * CSCI 2010
 * Programming Assignment 2
 * This the interface that allows encrypt and decrypt to be called on by all classes that implement Cipher.
 */
public interface Cipher{
    //Takes plainText as a parameter to be encrypted using the appropriate class
    public String encrypt(String plainText);
    //Takes cipherText as a parameter to be decrypted using the appropriate class
    public String decrypt(String cipherText);
}