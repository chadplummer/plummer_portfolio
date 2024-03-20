package csci2011.plummerlab7;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author chad.plummer
 * CSCI 2011 Lab 7
 * included at the bottom of this file is all of the code used prior to using writeLinesToFile.
 */
public class PlummerLab7 {

    public static void main(String[] args) {
        //open a new file called lab7Test.txt and then writes to the file with writeLinesToFile
            try(PrintWriter outputStream = openFileForWriting("lab7Test.txt")){
                System.out.println("Opened file lab7Test.txt for writing");
                int count = writeLinesToFile(outputStream);
                System.out.println("Wrote " + count + " lines to lab7Test.txt");
                System.out.println();
                outputStream.close();
            }
           //Opens the file and reads all text within it, then says how many lines wer read
            System.out.println("Opened file lab7Test.txt for reading");
            int count = readLinesFromFile(openFileForReading("lab7Test.txt"));
            System.out.println("Read " + count + " lines from lab7Test.txt");
            System.out.println();
            //Opens the file back up to be appended
            try(PrintWriter outputStream = openFileForAppending("lab7Test.txt")){
                System.out.println("Opened file lab7Test.txt for appending");
                int appendedCount = writeLinesToFile(outputStream);
                System.out.println("Wrote " + appendedCount + " lines to lab7Test.txt");
                System.out.println();
                outputStream.close();
            }
            System.out.println("Opened file lab7Test.txt for reading");
            count = readLinesFromFile(openFileForReading("lab7Test.txt"));
            System.out.println("Read " + count + " lines from lab7Test.txt");
            System.out.println();
        }
        
        //takes the fileName as a parameter and then opens a new file with that name
    public static PrintWriter openFileForWriting(String name){
        String fileName = name;
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(fileName);
            
        }catch (FileNotFoundException e){
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
        return outputStream;
    }
    //opens a prexisting file to edit further
    public static PrintWriter openFileForAppending(String name){
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(new FileOutputStream(name, true));
            
        }
        catch(FileNotFoundException e){
            System.out.println("Error, " + name + " file not found");
            System.exit(0);
        }
        return outputStream;        
    }
    //opens a preexisting file in order to be read, returns a scanner object
    public static Scanner openFileForReading(String name){
        Scanner inputStream = null;
        
        try{
            inputStream = new Scanner(new File(name));
        }catch(FileNotFoundException e)
        {
            System.out.println("Error opening file" + name);
            System.exit(0);
        }
        return inputStream;
    }
    //uses the scanner returned from openFileForReading to read each line and then returns how many lines it read
    public static int readLinesFromFile(Scanner file){
        Scanner inputStream = file;
        int count = 0;
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            System.out.println(line);
            count++;
        }
        inputStream.close();
        return count;
    }
    //uses the PrintWriter object returned from either openFileForWriting or openFileForAppending and then asks for input
    //that input is stored as a new line on the file. Returns the total number of lines added during this call
    public static int writeLinesToFile(PrintWriter file){
        int count = 0;
        Scanner inputStream = new Scanner(System.in);
        System.out.println("Enter the text you want to the file. Enter a blank line when you are done.");
        String line = "";
        do{
            line = inputStream.nextLine();
        if (line.equalsIgnoreCase("") != true){
            file.println(line);
            count++;
        }
        }while(line.equalsIgnoreCase("") != true);
        return count;
    }
}
//This is the original code used in main prior to writeLinesToFile
        /**try (PrintWriter outputStream = openFileForWriting("lab7Test.txt")) {
            System.out.println("Opened file lab7Test.txt for writing");
            
            outputStream.println("Test Line 1");
            outputStream.println("aye boiiiiiii Line 2");
            outputStream.println("Ahoy, matey Line 3");
            outputStream.println("Shirorororo Line 4");
            System.out.println("Wrote 4 lines to lab7Test.txt");
            System.out.println();
            outputStream.close();
        }
        int count = readLinesFromFile(openFileForReading("lab7Test.txt"));
        System.out.println("Read " + count + " lines from lab7Test.txt");
        System.out.println();
        
        try (PrintWriter appendedFile = openFileForAppending("lab7Test.txt")) {
            System.out.println("Opened file lab7Test.txt for appending");
            appendedFile.println("Yahaha the file was appended line 5");
            appendedFile.println("Yahaha the file was appended line 6");
            System.out.println("Write 2 lines to lab7Test.txt");
            System.out.println();
            }
        count = readLinesFromFile(openFileForReading("lab7Test.txt"));
        System.out.println("Read " + count + " lines from lab7Test.txt");
        System.out.println();**/
