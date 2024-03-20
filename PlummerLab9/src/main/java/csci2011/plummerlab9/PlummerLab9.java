package csci2011.plummerlab9;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author chad.plummer
 * CSCI Lab 9
 * The following assignment uses the MovieActors class and the following methods within the main class:
 * addMovieActors - this method prompts the user for the name of an actor, the movie they were in, and the
 * release date of the movie. It then places that info into a constructor for the MovieActors class and 
 * returns the new MovieActors Object
 * displayMovie - this takes the ArrayList made in main as a parameter and the collects the movie and year 
 * from each object in the ArrayList and puts it into a HashSet. The HashSet is then printed out onto the screen
 * displayActor - this takes the ArrayList made in main as a parameter and collects the actorName from each object in the 
 * ArrayList and puts it into a HashSet and prints the HashSet onto the screen.
 * 
 * main - calls addMovieActors until told to stop by the user. It creates an ArrayList with all of the MovieActor Objects
 * created by the user and calls displayMovie and displayActor using the ArrayList as a parameter.
 */
public class PlummerLab9 {

    public static void main(String[] args) {
        ArrayList<MovieActors> list = new ArrayList<>();
        String choice = "Y";
        while(choice.equalsIgnoreCase("Y")){
            System.out.println("Enter movie information below");
            MovieActors actor = addMovieActors();
            list.add(actor);
            Scanner input = new Scanner(System.in);
            System.out.print("Continue adding movie information? ");
            choice = input.next();
            System.out.println();
        }
        for(int i = 0; i< list.size(); i++){
            System.out.println();
            System.out.println(list.get(i).toString());
        }
        System.out.println();
        displayMovie(list);
        System.out.println();
        displayActor(list);
        System.out.println();
    }
    public static MovieActors addMovieActors(){
        Scanner input = new Scanner(System.in);
        System.out.println("Actor name: ");
        String name = input.nextLine();
        System.out.println("Input Movie Name: ");
        String movie = input.nextLine();
        System.out.println("Input the year of release: ");
        int year = input.nextInt();
        //input.close();
        MovieActors actor = new MovieActors(name, movie, year);
        return actor;
    }
    public static void displayMovie(ArrayList<MovieActors> list){
        HashSet<String> movieString = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            String movie = list.get(i).getMovie();
            int year = list.get(i).getYear();
            String movieInfo = movie + " - " + year;
            movieString.add(movieInfo);
            
        }
        System.out.println(movieString);
    }
    public static void displayActor(ArrayList<MovieActors> list){
        HashSet<String> uniqueActors = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            String actor = list.get(i).getActor();
            uniqueActors.add(actor);
        }
        System.out.println(uniqueActors);
    }
    
}
