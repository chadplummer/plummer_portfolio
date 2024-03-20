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
public class Album {
    private int Max_Num_Songs = 0;
    private String title;
    private String artist;
    private Song[] tracklist;
    //initialize takes 2 strings and an array of Song objects as parameters and sets them to the private instance
    //variables for the album. 
    public void initialize(String initialTitle, String initialArtist, Song[] initialTracklist){
        title = initialTitle;
        artist = initialArtist;
        Max_Num_Songs = initialTracklist.length;
        tracklist = new Song[Max_Num_Songs];
        //System.arraycopy(tracklist, 0, initialTracklist, 0, initialTracklist.length);
        for(int i = 0; i < initialTracklist.length; i++){
            tracklist[i] = new Song();
            tracklist[i].initialize(initialTracklist[i].getTitle(), initialTracklist[i].getArtist(), initialTracklist[i].getMinutes(), initialTracklist[i].getSeconds());
        }
    }
    //accessor for Album title
    public String getTitle(){
        return title;
    }
    //accessor for album artist
    public String getArtist(){
        return artist;
    }
    //accessor for album track number
    public int getNumTracks(){
        return tracklist.length;
    }
    //getTrack takes a number as a parameter and returns the song associated with that number in the array
    public Song getTrack(int trackNum){
        if (trackNum <= tracklist.length && trackNum > 0) {
            return tracklist[trackNum - 1];
        }
        else{
            return null;
        }
    }
    //comesBefore will take otherAlbum as a parameter and and checks to see if the artist of this comes before
    //otherAlbum in alphabetical order, returns true is it is earlier, false otherwise.
    //If artist is the same then it will test the the album title.
    public boolean comesBefore(Album otherAlbum){
        if (artist.compareToIgnoreCase(otherAlbum.artist) < 0){
            return true;
        }
        else if (artist.compareToIgnoreCase(otherAlbum.artist) == 0 && title.compareToIgnoreCase(otherAlbum.title) < 0){
            return true;
        }
        else {
            return false;
        }
    }
    //displayAlbum shows the album name, artist, and the number of tracks
    public void displayAlbum(){
        if (getNumTracks() > 1){
            System.out.println(getTitle() + " - " + getArtist() + " (" + getNumTracks()+ " tracks)");
        }
        else if (getNumTracks() == 1){
            System.out.println(getTitle() + " - " + getArtist() + " (" + getNumTracks()+ " track)");       
        }
        else{
            System.out.println("There is no album");
        }
    }
    //displayTracklist shows the title, artist, and lists the Song objects in the array
    public void displayTracklist(){
        for (int i = 0; i < tracklist.length; i++){
            System.out.printf(i+1 + ". ");
            tracklist[i].displaySong();
        }
    }
}
