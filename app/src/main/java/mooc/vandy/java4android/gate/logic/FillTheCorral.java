package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }
    public void setCorralGates(Gate[] gates,Random selectionDirection){
        int randomswing=selectionDirection.nextInt(3);
        final int IN=1;
        final int OUT=2;
        for(Gate gate:gates){
            if(randomswing==IN){
                gate.open(Gate.IN);
            }
            else if(randomswing==OUT)
                gate.open(Gate.OUT);
            else
                gate.open(Gate.CLOSED);
        }
    }
    public boolean anyCorralAvailable(Gate[] corral){
        for(Gate cor:corral) {
            if (cor.getSwingDirection() == Gate.IN)
                return true;
        }
                return false;
    }
    public int corralSnails(Gate[] corral,Random rand){
        int snailpasture=5;
        int count=0;
        while(snailpasture>0){
            count+=1;
            int s=rand.nextInt(snailpasture);
            int gate=rand.nextInt();
            if(corral[gate].getSwingDirection()==Gate.IN){
                snailpasture-=s;
            }
            else
                snailpasture+=s;
            mOut.println(s+"are trying to move through corral "+gate);
        }
        mOut.println("It took"+ count+ "attempts to corral al of the snails ");
        return count;

    }


    // TODO -- Fill your code in here

}
