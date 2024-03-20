package csci2011.lab2;
/**
 *
 * @author chad.plummer
 * This Class initializes a Record Object, displays the record information,
 * and checks to see if a Record comes before an otherRecord based on artist
 * or year.
 */
public class Record{

    private String record;
    private String artist;
    private int year;
    
    public void initialize(String initialRecord,String initialArtist, int initialYear){
        record = initialRecord;
        artist = initialArtist;
        year = initialYear;
    }
    
    public String getRecord(){
        return record;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public int getYear(){
        return year;
    }
    
    public void display(){
        System.out.println(record + " - " + artist + " (" + year + ")");
    }
    
    //Build the comesBefore code here.
    public boolean comesBefore(Record otherRecord){
        //If this comes before OtherRecord then this result is < 0, if after then it is > 0, if same then 0
        int result = this.artist.compareToIgnoreCase(otherRecord.artist);
        if (result < 0){
            return true;
        }
        
        else if (result == 0 && this.getYear() < otherRecord.getYear()){
            return true;
        }
        
        else{
            return false;
        }
    }
}
