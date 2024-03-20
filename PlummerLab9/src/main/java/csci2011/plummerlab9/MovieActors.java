package csci2011.plummerlab9;
/**
 *
 * @author Chad Plummer
 * CSCSI 2011
 * The MOvieActors class includes a constructor for the Object to include a String - actorName, String movieName, and 
 * an int year. toString has been overridden and there are three accessor methods included
 *
 */
public class MovieActors {
    String actorName;
    String movieName;
    int year;
    
    public MovieActors(String name, String movie, int newYear){
        actorName = name;
        movieName = movie;
        year = newYear;
    }
    public MovieActors(){
        actorName = null;
        movieName = null;
        year = 0;
    }
    @Override
    public String toString(){
        return ("Actor Name: " + actorName + "\n" +
                "Movie Title: " + movieName + "\n" +
                "Release Year: " + year);
    }
    public String getMovie(){
        return movieName;
    }
    public int getYear(){
        return year;
    }
    public String getActor(){
        return actorName;
    }
}
