package csci2010.plummerprogram3;
import java.util.Scanner;

/**
 *
 * @author chad.plummer
 * This is the main file for the Hanoi Tower simulation. It uses a while loop to ask whether or not the user
 * wants to continue to run the program. It creates a HanoiSimulation object and calls runSim to move all discs from
 * rod A to Rod B.
 */
public class PlummerProgram3 {

    public static void main(String[] args) {
        String answer = "Y";
        
            System.out.println("Welcome to Chad Plummer's Hanoi Tower Simulation!");
            
            while(answer.equalsIgnoreCase("Y")){
                Scanner input = new Scanner(System.in);
                System.out.println("How many discs do you wish to simulate?");
                int discs = input.nextInt();
                HanoiSimulation test = new HanoiSimulation(discs);
                System.out.println();
                test.runSim(discs);
                System.out.print("Would you like to run another simulation? (Y/N) ");
                answer = input.next();
                System.out.println(); 
            }
            System.out.println("Thank you for using Chad Plummer's Hanoi Tower Simulation.");
        
    }
}
