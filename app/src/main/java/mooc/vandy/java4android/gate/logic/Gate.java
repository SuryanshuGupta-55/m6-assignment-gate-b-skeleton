package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    /*Variable for swing direction*/
    public static final int IN=1;//snails will come in pen and gate will be open inward.
    public static final int OUT=-1;//snails will leave from pen and gate will be open outward.
    public static final int CLOSED=0;//no movement of snails are alllowed.
    public int mSwing;//current swing of the gate.
    public boolean setSwing(int direction){
        if(direction==IN || direction==OUT) {
            mSwing=direction;
            return true;
        }
        else
            return false;
    }
    public boolean open(int direction){
        if(direction==IN || direction ==OUT){
            setSwing(direction);
            return true;
        }
        else
            return false;
    }
    public void close(){
        setSwing(0);
    }
    public int thru(int count){
        if(mSwing==IN){
            return count+mSwing;
        }
        else if(mSwing==OUT){
            return count-mSwing;
        }
        else
            return 0;
    }
    public int getSwingDirection(){
        return mSwing;
    }
    public String toString(){
        if (mSwing == CLOSED)
            return "This gate is closed";
        else if (mSwing == IN){
            return "This gate is open and swings to enter the pen only";
        }
        else if (mSwing == OUT){
            return "This gate is open and swings to exit the pen only";
        }
        else
            return "This gate has an invalid swing direction";
    }
}
