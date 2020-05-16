package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;
    public static final int HERD=24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;//This gate will open inside.
        mWestGate.open(Gate.IN);//This gate allows snails to leave pasture and make them enter into pen.

        mEastGate = eastGate;//This gate will be open outside.
        mEastGate.open(Gate.OUT);//This gate allows snails to leave pen and make them enter into pasture.
    }
    public void simulateHerd(Random rand){
        int snailsinpen=HERD;//count of snails initially in the pen.
        int snailsinpasture=0;//count of snails initially out in pasture.
        int gate;//to get the randomly generated gate.
        final int east=1;//variable to indicate to east gate.
        int movesnails;
        mOut.println("There are currently "+ snailsinpen+ " snails in the pen and "+ snailsinpasture + " snails in the pasture");


        for(int i=0;i<MAX_ITERATIONS;i++){
            gate=rand.nextInt(2);
            if(gate==east){
                movesnails=rand.nextInt(snailsinpen)+1;
                snailsinpen+=mEastGate.thru(movesnails);
                snailsinpasture=snailsinpen-movesnails;
            }
            else
            {
                movesnails=rand.nextInt(snailsinpen)+1;
                snailsinpen+=mWestGate.thru(movesnails);
                snailsinpasture=snailsinpen-movesnails;
            }
            mOut.println("There are currently "+ snailsinpen+ " snails in the pen and "+ snailsinpasture + " snails in the pasture");
        }
    }
    // TODO -- Fill your code in here


}
