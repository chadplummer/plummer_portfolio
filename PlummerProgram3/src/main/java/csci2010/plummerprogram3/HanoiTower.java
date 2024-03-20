package csci2010.plummerprogram3;

/**
 *
 * @author chad.plummer
 */
public class HanoiTower {
    private int[] discsOnRod;
    private int currentNumDiscs;
    private String rodName;
    private int maxNumDiscs;
    
    public HanoiTower(){
        discsOnRod = new int[0];
        currentNumDiscs = 0;
        rodName = null;
        maxNumDiscs = 0;
    }
    /**
     * 
     * @param numOfDiscs = sets the maximum number of discs allowed on a rod
     * @param rod = creates the name for the rod object
     */
    public HanoiTower(int numOfDiscs, String rod){
        maxNumDiscs = numOfDiscs;
        rodName = rod;
        discsOnRod = new int[maxNumDiscs];
        currentNumDiscs = 0;
    }
    /**
     * 
     * @param newDisc This identifies which disc is going to be moved
     * @throws IllegalPushException
     * @throws TowerOverflowException 
     * push adds the disc onto the rod that this is called onto. the disc must be smaller than the one it is sitting on top
     * of and the rod cannot be full.
     */
    public void push(int newDisc) throws IllegalPushException, TowerOverflowException{
            if(currentNumDiscs == maxNumDiscs){
                throw new TowerOverflowException();
            }
            if(currentNumDiscs > 0 && discsOnRod[currentNumDiscs - 1] < newDisc){
                throw new IllegalPushException();
            }
            discsOnRod[currentNumDiscs] = newDisc;
            currentNumDiscs++;
    }
    /**
     * 
     * @return what disc is currently at the top of the rod
     * @throws EmptyTowerException 
     * pop removes the top disc from the rod.
     */
    public int pop() throws EmptyTowerException{
            if(currentNumDiscs == 0){
                throw new EmptyTowerException();
            }
            currentNumDiscs--;
            return discsOnRod[currentNumDiscs];
    }
    /**
     * 
     * @return 
     * toString prints out the name of the rod and then all of the discs attached to it by using a for loop
     */
    @Override
    public String toString(){
        System.out.print("Rod " + rodName + ": ");
        for(int i = 0; i < currentNumDiscs; i++){
            System.out.print(discsOnRod[i] + " ");
        }
        System.out.println();
        return null;
    }

}
