package csci2011.lab2;


/**
 *
 * @author chad.plummer
 * This main class program sorts adds 3 new Record objects and and RecordCollection object.
 * Once it creates these objects it will add the Record objects to the RecordCollection object,
 * then run a test search method to find records in the RecordCollection. Afterwards it will 
 * sort through the RecordCollection and sort them into alphabetical order based on Artist then 
 * Year if the artist is the same.
 */
public class Lab2 {
    
    public static void main(String[] args) {

        // TODO code application logic here
      Record record1 = new Record();
      Record record2 = new Record();
      Record record3 = new Record();
      
      record1.initialize("State of Decay", "My Chemical Romance", 2022);
      record2.initialize("Blonde", "Waterparks", 2016);
      record3.initialize("Teenagers", "My Chemical Romance", 2006);
      
      testComesBefore(record1, record2);
      testComesBefore(record3, record1);
      testComesBefore(record1, record3);
      
      RecordCollection rc = new RecordCollection();
      rc.initialize(3);
      
      testRCDisplay(rc);
      testAddRecord(rc, record1);
      testAddRecord(rc, record2);
      testAddRecord(rc, record3);
      
      testFindRecord(rc, "Blonde", "Waterparks");
      testFindRecord(rc, "Fireflies", "Owl City");
      
      testSortRecords(rc);
      
    }
    public static void testComesBefore (Record test, Record test2){
        System.out.println("Testing comesBefore method: ");
        test.display(); test2.display();
        if (test.comesBefore(test2)){
            System.out.println(test.getRecord() + " comes before " + test2.getRecord());
            System.out.println();
        }
        else{
            System.out.println(test.getRecord() + " does not come before " + test2.getRecord());
            System.out.println();
        }
        
            
    }
    public static void testRCDisplay(RecordCollection testRC){
        System.out.println("Testing Display");
        testRC.display();
        int num = testRC.getNumRecords();
        System.out.println("Number of Records: " + num);
        System.out.println();
        
    }
    public static void testAddRecord(RecordCollection testRC, Record testRecord){
        
        System.out.println("Testing addRecord:");
        System.out.print("Adding ");
        testRecord.display();
        boolean recordAdded = testRC.addRecord(testRecord);
        if (recordAdded == true){
            testRC.display();
            int num = testRC.getNumRecords();
            System.out.println("Number of Records: " + num);
            System.out.println();
        }
        else{
            System.out.println("Cannot add record");
            System.out.println();
        }
    }
    public static void testFindRecord(RecordCollection testRC, String title, String artist){
        System.out.println("Testing findRecord");
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        Record result = new Record();
        result = testRC.findRecord(title, artist);
        if (result == null){
            System.out.println("not found");
            System.out.println();
        }
        else{
            System.out.print("Found: ");
            result.display();
            System.out.println();
        }
    }
    public static void testSortRecords(RecordCollection testRC){
        System.out.println("Testing sortRecords: ");
        testRC.sortRecords();
        testRC.display();
        System.out.println();
    }

}