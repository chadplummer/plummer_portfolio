package csci2010.plummerprogram5;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author chad.plummer
 * CSCI 2010 Assignment 5
 * Methods included in Assignment 5:
 * Main creates 2 LinkedList of type String and Double respectively and prompts the user
 * for info on a stadium and the number of money made at that game.
 * Once the user types "done" then the main method asks the user to search for a specific stadium
 * the main method then iterates through the LinkedList<String> to until it either finds
 * the stadium that was searched for OR until it reaches null.
 * if the stadium is found within the LinkedList then it calls iterateStadiums to calculate the total
 * revenue that specific stadium had.
 * 
 * iterateStadiums take 3 parameters. A LinkedList<String>, a LinkedList<Double>, and a String called search
 *      It then searches through the LinkedList<String> to find all instances of search.
 *      Each time it locates a matching value to search it will then go to the corresponding node of the 
 *      LinkedList<Double> and add that value to the total number of revenue. Once it has gone through
 *      the entire LinkedList<String> it then returns the total.
 */
public class PlummerProgram5 {

    public static void main(String[] args) {
        LinkedList<String> stadiumNames = new LinkedList<>();
        LinkedList<Double> gameRevenue = new LinkedList<>();
        System.out.println("Enter the data now.");
        System.out.println("On each line enter a stadium name and the game revenue");
        System.out.println("Enter done when you are finished");
        
        Scanner input = new Scanner(System.in);
        String choice = "Y";
        
        while(!choice.equalsIgnoreCase("done")){
        
            if(input.hasNext()){
                choice = input.next();
                if(!choice.equalsIgnoreCase("done")){
                    stadiumNames.add(choice);
                    gameRevenue.add(input.nextDouble());
                }
            }
        }
        System.out.println("Enter the name of a stadium to get the total revenue for: ");
        input.nextLine();
        String stadiumSearch = input.nextLine();
        if (stadiumNames.contains(stadiumSearch)){
            System.out.println(stadiumSearch + " found!");
            System.out.println("The total revenue is " + iterateStadiums(stadiumNames, gameRevenue, stadiumSearch));
            System.out.println();
        }
        else{
            System.out.println(stadiumSearch + " not found.");
        }
    }
    
    public static double iterateStadiums(LinkedList<String> stadiumList, LinkedList<Double> gameList, String search){
        String current;
        int count = 0;
        double total = 0;
        for (int i = 0; i < stadiumList.size(); i++){  
            current = stadiumList.get(i);
            if(current.equalsIgnoreCase(search))
            {
                total = total + gameList.get(count);
            }
            count++;
        }
        return total;
    }
}
