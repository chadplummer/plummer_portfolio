package csci2010.plummerprogram4;

import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.parseInt;
/**
 *
 * @author chad.plummer
 * This program uses the Player class to store each entry from the txt file to a file called playerData.dat
 * This program has the following methods:
 * countPlayers - This method opens up the txt file and counts how many total records there are and then returns the number
 * loadPlayers - This program calls countPlayers then uses that to initialize the array that will be written to.
 *                  It then reads the file "womenSinglesDraw2.txt" and stores each value as a Player object in a 
 *                  Player array. Afterwards it stores the entire array into the file "playerData.dat"
 * displayMenu - Shows the menu used to select the task
 * getChoice - This calls display menu and takes an int to make a selection of what function to call next
 * findPlayerByName - opens up the dat file and searches for a record where the name matches the inquiry, if not found 
 *                      throws a NoSuchPlayerException
 * findPlayerByCountry - opens up the dat file and searches for a record where the country matches the inquiry, if not found 
 *                      throws a NoSuchPlayerException
 * findYoungestPlayer - opens up the dat file and searches for the player with the youngest age and then displays it
 * findOldestPlayer - opens up the dat file and searches for the oldest player and then displays it
 */
public class PlummerProgram4 {

    public static void main(String[] args) {
    loadPlayers();
    getChoice();
    }
    
    public static void loadPlayers(){
        System.out.println("Loading players from file...");
        String fileName = "womenSinglesDraw2.txt";
        int count = countPlayers(fileName);
        Player[] players = new Player[count];
        try{
            int i = 0;
            Scanner inputStream = new Scanner(new File(fileName));
            while(inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                String[] playerData = line.split(",");
                String name = playerData[0];
                int age = parseInt(playerData[1]);
                int rank = parseInt(playerData[2]);
                String country = playerData[3];
                players[i] = new Player(name, age, rank, country);
                //System.out.println("Stored player " + (i+1));
                //System.out.println(players[i].toString());
                i++;
            }
            try{
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("playerData.dat"));
                outputStream.writeObject(players);
                outputStream.close();
                System.out.println("Successfully loaded player data");
            }catch(IOException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static int countPlayers(String fileName){
        int count = 0;
        try{
            Scanner input = new Scanner(new File(fileName));
        
            while(input.hasNextLine()){
                count++;
                input.nextLine();
            }
            input.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }    
        return count;
    }
    
    public static void displayMenu(){
        String menu = ("Choose one of the following options" + "\n" + 
                        "1. Find a player by name" + "\n" + 
                        "2. Find all players from a country" + "\n" + 
                        "3. Find the youngest player" + "\n" + 
                        "4. Find the oldest player" + "\n" +
                        "5. Exit" + "\n" +
                        "6. Find the best player" + "\n" +
                        "7. Find the worst player" + "\n" +
                        "8. Find median player");
        System.out.println(menu);
    }
    
    public static void getChoice(){
        int choice = 0;
        
        while(choice != 5){
            displayMenu();
            Scanner inputChoice = new Scanner(System.in);
            System.out.println("Enter Choice: ");
            if(inputChoice.hasNextInt()){
                choice = inputChoice.nextInt();
            }
            if(choice == 1){
                Scanner inputName = new Scanner(System.in);
                System.out.println("Please enter the player's name");
                String nameSearch = inputName.nextLine();
                System.out.println();
                findPlayerByName(nameSearch);
                System.out.println();
            }
            else if(choice == 2){
                Scanner inputCountry = new Scanner(System.in);
                System.out.println("Please enter the country: ");
                String searchCountry = inputCountry.nextLine();
                System.out.println();
                findPlayerByCountry(searchCountry);
                System.out.println();
            }
            else if(choice ==3){
                findYoungestPlayer();
            }
            else if(choice == 4){
                findOldestPlayer();
            }
            else if(choice == 5){
                System.out.println("Program Exiting");
                System.exit(0);
            }
            else if(choice == 6){
                Player best = findBestPlayer();
                System.out.println("Best Player: ");
                System.out.println(best.toString());
                
            }
            else if(choice == 7){
                Player worst = findWorstPlayer();
                System.out.println("Worst Player: ");
                System.out.println(worst.toString());
            }
            else if(choice == 8){
                findMedianPlayer();
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        
    }
    
    public static void findPlayerByName(String nameSearch){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            try{
            for(int i = 0; i < tempInput.length; i++){
                if(tempInput[i].getName().equalsIgnoreCase(nameSearch)){
                    System.out.println(tempInput[i].toString());
                    return;
                }
            }throw new NoSuchPlayerException();
            }catch(NoSuchPlayerException e){
            System.out.println(e.getMessage() + nameSearch);
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void findPlayerByCountry(String searchCountry){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            int confirm = 0;
            try{
                for(int i = 0; i < tempInput.length; i++){
                    if(tempInput[i].getCountry().equalsIgnoreCase(searchCountry)){
                        System.out.println(tempInput[i].getName());
                        confirm = 1;
                    }
                }
                if(confirm == 0){
                    throw new NoSuchPlayerException();
                }
            }catch(NoSuchPlayerException e){
                System.out.println("There are no players from this country: " + "\n" + searchCountry);
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    public static void findYoungestPlayer(){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerdata.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            Player youngestPlayer= new Player();
                int youngest = tempInput[0].getAge();
                for(int i = 0; i < tempInput.length; i++){
                    if(tempInput[i].getAge() <= youngest){
                        youngest = tempInput[i].getAge();
                        youngestPlayer.setName(tempInput[i].getName());
                        youngestPlayer.setAge(tempInput[i].getAge());
                        youngestPlayer.setCountry(tempInput[i].getCountry());
                        youngestPlayer.setRank(tempInput[i].getRank());
                    }
                }
                System.out.println(youngestPlayer.toString());
                System.out.println();
                

        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    public static void findOldestPlayer(){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            Player oldestPlayer = new Player();
            int oldest = tempInput[0].getAge();
            for(int i = 0; i < tempInput.length; i++){
                if(tempInput[i].getAge() >= oldest){
                    oldest = tempInput[i].getAge();
                    oldestPlayer.setName(tempInput[i].getName());
                    oldestPlayer.setAge(tempInput[i].getAge());
                    oldestPlayer.setCountry(tempInput[i].getCountry());
                    oldestPlayer.setRank(tempInput[i].getRank());
                }
            }
            System.out.println(oldestPlayer.toString());
            System.out.println();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static Player findBestPlayer(){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            Player best = tempInput[0];
            for(int i = 0; i < tempInput.length; i++){
                if(tempInput[i].getRank() < best.getRank()){
                    best = tempInput[i];
                }
            }
                return best;
            
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }
    public static Player findWorstPlayer(){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            Player worst = tempInput[0];
            for(int i = 0; i < tempInput.length; i++){
                if(tempInput[i].getRank() > worst.getRank()){
                    worst = tempInput[i];
                }
            }
            
            return worst;
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }
    public static void findMedianPlayer(){
        Player[] tempInput;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("playerData.dat"));
            tempInput = (Player[])inputStream.readObject();
            inputStream.close();
            
            for(int i = 0; i < tempInput.length; i++){
                if(tempInput[i].getRank() == 301){
                    System.out.println("Player at rank " + 300 + ": ");
                    System.out.println(tempInput[i].toString());
                    return;
                }
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
