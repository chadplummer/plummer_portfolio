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
public class AlbumCollection {
    public int maxNumAlbums = 10;
    private int numOfAlbums;
    private Album[] albumCollection;

    //initilize is the constructor for the album array called albumCollection
    public void initialize(){
        numOfAlbums = 0;
        albumCollection = new Album[maxNumAlbums];
    }
    //accessor for the number of albums in the array
    public int getNumOfAlbums(){
        return numOfAlbums;
    }
    //this will add albums to the collection as long as the collection is not full. Otherwise it returns false.
    public boolean addAlbum(Album newAlbum){
        if (numOfAlbums == maxNumAlbums){
            return false;
        }
        else{
            albumCollection[getNumOfAlbums()] = newAlbum;
            numOfAlbums++;
            return true;
        }
    }
    //This takes an album title and artist and searches for an album with both of those as variables. 
    //returns null if the album is not found.
    public Album findAlbum(String title, String artist){
        for (int i = 0; i < numOfAlbums; i++){
            if (albumCollection[i].getTitle().compareToIgnoreCase(title) == 0 && albumCollection[i].getArtist().compareToIgnoreCase(artist) == 0){
                return albumCollection[i];
            }
        }
        return null;
    }
    //This is a selection sort that will sort the albums in alphabetical order based on the artist
    public void sortAlbum(){
        Album min = new Album();
        min = this.albumCollection[0];
        Album temp = new Album();
        for (int i = 0; i < numOfAlbums - 1; i++){
            min = this.albumCollection[i];
            for (int j = i + 1; j < numOfAlbums; j++){
                if(this.albumCollection[j].comesBefore(min) == true){
                    //Album temp = new Album();
                    min = this.albumCollection[j];
                    temp = min;
                    this.albumCollection[j] = this.albumCollection[i];
                    this.albumCollection[i] = temp;
                }

            }   
        }
    }
    //displayAlbums uses a for loop to call displayAlbum() for each album within the array.
    public void displayAlbums(){
        for(int i = 0; i < numOfAlbums; i++){
            albumCollection[i].displayAlbum();
        }
            System.out.println();
    }
    //displaySongs uses a for loop to call displayAlbum and displayTracklist for each album in the array.
    public void displaySongs(){
        for(int i = 0; i < numOfAlbums; i++){
            albumCollection[i].displayAlbum();
            albumCollection[i].displayTracklist();
            System.out.println();
        }
    }
    
}
