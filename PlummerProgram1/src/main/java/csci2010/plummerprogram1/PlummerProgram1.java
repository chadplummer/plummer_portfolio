package csci2010.plummerprogram1;
import java.util.Scanner;

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
public class PlummerProgram1 {

    public static void main(String[] args) {
        AlbumCollection albumCollection = new AlbumCollection();
        albumCollection.initialize();
        Playlist playlist = new Playlist();
        playlist.initialize();
        
        System.out.println("Welcome to Chad Plummer's Music Manager");
        System.out.println();
        int choice = 0;
        while (choice == 0){
            displayMenu();
            choice = getChoice();
            if (choice == 1){
                Album newAlbum = new Album();
                newAlbum = createAlbum();
                if (albumCollection.addAlbum(newAlbum) == false)
                {
                    System.out.println("Error, Album Collection is full");
                    System.out.println();
                }
            }
            else if (choice == 2){
                albumCollection.displayAlbums();
                System.out.println();
            }
            else if (choice ==3){
                albumCollection.displaySongs();
            }
            else if (choice == 4){
                albumCollection.sortAlbum();
            }
            else if (choice ==5){
                Album result = new Album();
                result = getAlbumFromCollection(albumCollection);
                if (result != null){
                    Song selectedSong = new Song();
                    selectedSong = getSongFromAlbum(result);
                    if (selectedSong != null){
                        if (playlist.addSong(selectedSong) == false){
                            System.out.println("Error, playlist is full");
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("Error, song is not in the Album Collection");
                        System.out.println();
                    }
                }
            }
            else if (choice == 6){
                playlist.display();
                System.out.println();
            }
            else if (choice == 7){
                playlist.clear();
                System.out.println("Playlist has been cleared");
                System.out.println();
            }
            else if (choice == 8){
                System.out.println("Thank you for using Chad Plummer's Music Manager");
                return;
            }
            else {
                System.out.println("Error, you must input a number from 1-8");
                System.out.println();
            }
            choice = 0;
        }
    }
    //displayMenu will display a menu with options 1 - 8.
    private static void displayMenu(){
        System.out.println("Choose one of the following:");
        System.out.println("1. Add an album to the collection");
        System.out.println("2. Display the albums in the collection");
        System.out.println("3. Display the songs in the collection");
        System.out.println("4. Sort the albums in the the collection");
        System.out.println("5. Add a song to the playlist");
        System.out.println("6. Display the playlist");
        System.out.println("7. Clear playlist");
        System.out.println("8. Exit the program");
    }
    //getChoice() gathers input from the user via Scanner that will be used in main() for selecting a menu option
    private static int getChoice(){
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()){
            int choice = input.nextInt();
            return choice;
        }
        else{
            int choice = -1;
            return choice;
        }
    }
    //createAlbum() uses Scanner to gather the album title and artist to create a new album
    //then creates an array of Song objects and calls getTracklist() to create the tracklist for the album
    //finally it initilizes the album with the title, artist and tracklist and returns the album object.
    private static Album createAlbum(){
        int check = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Album Title: ");
        String albumName = input.nextLine();
        System.out.println();
        
        System.out.println("Album Artist: ");
        String artistName = input.nextLine();
        System.out.println();
        String numOfTracksString;
        int numOfTracks = 0;
        while(check == 0){
        System.out.println("How many tracks are on the album?");
        numOfTracksString = input.nextLine();
        try{
            numOfTracks = Integer.parseInt(numOfTracksString);
            check = 1;
        }
        catch (NumberFormatException e){
            System.out.println("Error, please input an integer starting from 1");
            numOfTracksString = null;
        }}
        Song[] albumTracklist = new Song[numOfTracks];
        albumTracklist = getTracklist(numOfTracks, artistName);
       
        Album newAlbum = new Album();
        newAlbum.initialize(albumName, artistName, albumTracklist);
        return newAlbum;
    }
    //getTracklist() creates an array of Song objects by collecting the songTitle and songLength in minutes
    //and seconds then initilizes a new song object for each object in the array then returns the tracklist
    private static Song[] getTracklist(int numOfTracks, String artist){
        Song[] newTracklist = new Song[numOfTracks];
        for (int i = 0; i < numOfTracks; i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Track " + (i + 1) + " title: ");
            String trackTitle = input.nextLine();
            int check = 0;
            int minutes = 0;
            int seconds = 0;
            String minutesString;
            String secondsString;
            
            while(check == 0){
            System.out.println("Track " + (i + 1)+ " length: ");
            minutesString = input.next();
            secondsString = input.next();
            try{
                minutes = Integer.parseInt(minutesString);
                seconds = Integer.parseInt(secondsString);
                input.nextLine();
                check = 1;
            }
            catch (NumberFormatException e){
                System.out.println("Error, please input an integer.");
                minutesString = null;
                secondsString = null;
            }
            }
            newTracklist[i] = new Song();
            newTracklist[i].initialize(trackTitle, artist, minutes, seconds);
        }
        return newTracklist;
    }
    //getAlbumFromCollection() takes an AlbumCollection as a parameter and uses scanner to find the album
    //if the user inputs an album that is NOT in the collection the program will tell the user and prompt again
    //for an album that is presen in the collection. It will return the album that was looked for.
    private static Album getAlbumFromCollection(AlbumCollection albumCollection){
        Scanner input = new Scanner(System.in);
        Album foundAlbum = new Album();
        foundAlbum = null;
        while (foundAlbum == null){
            System.out.println("Album Title: ");
            String albumTitle = input.nextLine();
            System.out.println("Album Artist: ");
            String albumArtist = input.nextLine();
            foundAlbum = albumCollection.findAlbum(albumTitle, albumArtist);
            if (foundAlbum == null){
                System.out.println("Album is not found in the collection");
            }
        }
        return foundAlbum;
    }
    //getSongFromAlbum takes an album as a parameter and searches the tracklist array within the album
    //for a Song Object for the user. It will returns that Song if found.
    private static Song getSongFromAlbum(Album album){
        Scanner input = new Scanner(System.in);
        Song foundSong = new Song();
        foundSong = null;
        while (foundSong == null){
            System.out.println("Choose one of the following:");
            album.displayTracklist();
            int selection = input.nextInt();
            foundSong = album.getTrack(selection);
        }
        return foundSong;
    }
}
