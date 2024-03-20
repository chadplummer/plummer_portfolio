package csci2010.plummerprogram3;
/**
 *
 * @chad.plummer
 * This is the primary object for the HanoiTower simulation. 
 */
public class HanoiSimulation {
    private int totalDiscs;
    private HanoiTower rodA;
    private HanoiTower rodB;
    private HanoiTower rodC;
    /**
     * HanoiSImulation constructor intializes the simulation by creating three Hanoi Tower objects named
     * rods A-C. The constructor takes an int as a parameter called num and sets the maximum number of discs for
     * each rod to num. Afterwards the constructor places all of the discs in descending order onto Rod A. This constructor
     * checks for any IllegalPushExceptions and TowerOverflowExceptions that are thrown from the push method found in the
     * HanoiTower class.
     */
    public HanoiSimulation(){
        totalDiscs = 0;
        rodA = new HanoiTower(totalDiscs, "A");
        rodB = new HanoiTower(totalDiscs, "B");
        rodC = new HanoiTower(totalDiscs, "C");
    }
    public HanoiSimulation(int num){
        totalDiscs = num;
        rodA = new HanoiTower(totalDiscs, "A");
        rodB = new HanoiTower(totalDiscs, "B");
        rodC = new HanoiTower(totalDiscs, "C");
        
        try{
            for(int i = totalDiscs; i > 0; i--){
                rodA.push(i);
            }
        }
            catch(IllegalPushException | TowerOverflowException e){
                    e.getMessage();
            }
        }
    /**
     * 
     * @param fromRod this is the starting rod for all of the discs to move away from
     * @param toRod This is the final destination for all discs
     * @param auxRod this is the helper rod
     * @param numOfDiscs identifies how many discs are sitting on the rod
     * moveDiscs calls itself recursively to move the discs from the source to the destination.
     */
    private void moveDiscs(HanoiTower fromRod, HanoiTower toRod, HanoiTower auxRod, int numOfDiscs){
        if(numOfDiscs == 1){
            try{
                toRod.push(fromRod.pop());
                displayTowers();
            }
            catch(EmptyTowerException | IllegalPushException | TowerOverflowException e){
                e.getMessage();
            }
        }
        else{
            try{
                moveDiscs(fromRod, auxRod, toRod, numOfDiscs-1);
                toRod.push(fromRod.pop());
                displayTowers();
                moveDiscs(auxRod, toRod, fromRod, numOfDiscs-1);
            }
            catch(EmptyTowerException | IllegalPushException | TowerOverflowException e){
                e.getMessage();
            }
        }
    }
    /**
     * displayTowers takes no parameters and calls toString on each HanoiTower object found within the simulation
     */
    public void displayTowers(){
        rodA.toString();
        rodB.toString();
        rodC.toString();
        System.out.println();
    }
    /**
     * 
     * @param discs
     * runSim uses the discs param to call the moveDiscs method on an existing HanoiSimulation object/
     */
    public void runSim(int discs){
        displayTowers();
        moveDiscs(rodA, rodB, rodC, discs);
    }
}
