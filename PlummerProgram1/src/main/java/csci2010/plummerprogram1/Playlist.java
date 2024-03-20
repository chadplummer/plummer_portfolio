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
public class Playlist {
    public int maxNumSongs = 1;
    private int numberOfSongs;
    private Song[] playlistSongs;
    //initialize is a constructor for playlist, an array of Song objects
    public void initialize(){
        numberOfSongs = 0;
        playlistSongs = new Song[maxNumSongs];
    }
    //accessor for numberOfSongs
    public int getNumOfSongs(){
        return numberOfSongs;
    }
    //getLength adds the length (in seconds) of each song and adds them together into the variable sum
    //afterwards, it returns the sum.
    public int getLength(){
        int sum = 0;
        for (int i = 0; i < numberOfSongs; i++){
            int songLength = playlistSongs[i].getSongLength(playlistSongs[i]);
            sum = sum +songLength;
        }
        return sum;
    }
    //addSong takes a Song as a parameter and returns true after adding a song to the array. If the array is full
    //it returns false.
    public boolean addSong(Song newSong){
        if (numberOfSongs == maxNumSongs){
            return false;
        }
        else{
            playlistSongs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true; 
        }
    }
    //display uses a for loop to display every Song object in the array.
    public void display(){
        for (int i = 0; i < numberOfSongs; i++)
        {
            playlistSongs[i].displaySong();
        }
        int total = this.getLength();
        int minutes = total/60;
        int seconds = total % 60; //fix the time here
        String paddedSeconds = String.format("%02d", seconds);
        System.out.println("Total Time: (" + minutes + ":" + paddedSeconds + ")");
    }
    //clear() sets the numberOfSongs to 0, thereby clearing the array.
    public void clear(){
        numberOfSongs = 0;
    }
}
