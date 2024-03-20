package csci2010.plummerprogram1;

/**
 *
 * @author chad.plummer
 * PlummerProgram1
 * CSCI 2010 Programming Assignment 1 due 9/9/2022
 * 
 * This program is separated into 5 different class files; Song, Album, AlbumCollection, and Playlist.
 * The main method displays the menu that the user select prompts by typing in the corresponding number.
 * If the user selection is not a valid choice the program will notify the user and loop back to the menu display
 * The user can add an album on option 1, it will utilize both the album and the song class. First they
 * will create an album object, then within that album object is an array of Song objects. 
 * 
 * Any album that is created will be added to the albumCollection array which can be displayed 
 * with or without the tracklist via options 1 and 3. Option 4 will alphabetize the albumCollection by artist.
 * Option 5 allows the user to add a song from the collection to a playlist array created via the playlist class.
 * Users can display the playlist and the total amount of time of the playlist via option 6. 
 * 
 * Option 7 clears the playlist array, while leaving the albumCollection completely intact.
 * Option 8 allows the user to exit the program.
 */
public class Song {
    private String title;
    private String artist;
    private int length;
    private int minutes;
    private int seconds;
//initialize() takes 2 strings and 2 ints as parameters and sets the private variables for the Song object
//in addition it converts the time from minutes and seconds to just seconds for the song.
    public void initialize(String initialTitle, String initialArtist, int initialMinutes, int initialSeconds){
        title = initialTitle;
        artist = initialArtist;
        length = (initialSeconds + (initialMinutes * 60));
        minutes = initialMinutes;
        seconds = initialSeconds;
    }
//diplaySong prints the song title, artist and song length in minutes and seconds
    public void displaySong(){
        String paddedSeconds = String.format("%02d", seconds);
        System.out.println(title + " - " + artist + " (" + minutes + ":" + paddedSeconds + ")");
    }
//getSongLength is the accessor method for the song length in seconds
    public int getSongLength(Song song){
        return length;
}
    //getTitle is the accessor for the Song's title
    public String getTitle(){
        return title;
    }
    //getArtist is the accessor for the Song's artist
    public String getArtist(){
        return artist;
    }
    //getMinutes is the accessor for the minutes of the song
    public int getMinutes(){
        return minutes;
    }
    //getSeconds is the accessor for the seconds of a song
    public int getSeconds(){
        return seconds;
    }
}