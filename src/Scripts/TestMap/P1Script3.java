package Scripts.TestMap;

import GameObject.IntersectableRectangle;
import GameObject.Rectangle;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class P1Script3 extends Script {
    @Override
    protected void setup() {
    	if (isFlagSet("RockOnTile1") && isFlagSet("RockOnTile2") && isFlagSet("RockOnTile3")) {
        	lockPlayer();
            showTextbox();
            addTextToTextboxQueue("You Completed the Puzzle!");
            addTextToTextboxQueue("You Got a Key!");
        }
    }

    @Override
    protected void cleanup() {
    	//setFlag("RockOnTile1");
        //setFlag("RockOnTile2");
        //setFlag("RockOnTile3");
        
        hideTextbox();
        unlockPlayer();
        setFlag("RockOnTile3");
    	/*if (isFlagSet("RockOnTile1") && isFlagSet("RockOnTile2") && isFlagSet("RockOnTile3")) {
            setFlag("hasFinishedPuzzle");
    	}*/
    }

    @Override
    public ScriptState execute() {
        if (!map.getFlagManager().isFlagSet("RockOnTile3")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
            map.getFlagManager().setFlag("RockOnTile3");
        }
        return ScriptState.COMPLETED;
    }

}
