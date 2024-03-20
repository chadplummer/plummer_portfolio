package csci2011.lab2;
/**
 *
 * @author chad.plummer
 * This creates a RecordCollection object array and initializes it, adds records to the 
 * collection, displays the collection by calling the display method from the Record class, 
 * finds and displays a record in the collection, then sorts the collection into alphabetical
 * order based on artist/year.
 */
public class RecordCollection {
    private int maxNumberOfRecords;
    private Record[] recordCollection;
    private int numberOfRecords;
    
    public void initialize(int max){
        maxNumberOfRecords = max;
        recordCollection = new Record[maxNumberOfRecords];
        numberOfRecords = 0;
    }
    public int getNumRecords(){
        return numberOfRecords;
    }
    public void display(){
        if(numberOfRecords == 0){
            System.out.println("No records in the collection");
        }
        else{
            for (int i = 0; i < recordCollection.length; i++){
                if (recordCollection[i] != null){
                    recordCollection[i].display();
                }
                else{
                    return;
                }
            }
        }
    }
    //Continue on number 10. of the lab doc 9/3/2022
    public boolean addRecord(Record record){
        if (record.getArtist() == null && recordCollection[maxNumberOfRecords] == null){
            return false;
        }
        else{
            recordCollection[numberOfRecords] = record;
            numberOfRecords++;
            return true;
        }
    }
    public Record findRecord(String title, String artist){
        for(int i = 0; i < numberOfRecords; i++){
            if (recordCollection[i].getRecord().compareToIgnoreCase(title) == 0){
                if (recordCollection[i].getArtist().compareToIgnoreCase(artist) == 0){
                    return recordCollection[i];
                }
                //else{
                    //return null;
                //}
            }
            //else{
                //return null;
            //}
        }
        return null;
    }
    
    public void sortRecords(){
        Record min = new Record();
        min = this.recordCollection[0];
        for (int j = 1; j < numberOfRecords; j++){
            min = this.recordCollection[0];
            for (int i = 1; i < numberOfRecords; i++){
                if (this.recordCollection[i].comesBefore(min) == true){
                    Record temp = new Record();
                    min = this.recordCollection[i];
                    temp = this.recordCollection[i-1];
                    this.recordCollection[i-1] = this.recordCollection[i];
                    this.recordCollection[i] = temp;         
                }
            }
        }
    }
}
