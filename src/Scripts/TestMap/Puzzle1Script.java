package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class Puzzle1Script extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("You Completed the Puzzle!");
        addTextToTextboxQueue("You Got a Key!");
       
        
    }

    @Override
    protected void cleanup() {
    	//setFlag("RockOnTile1");
        //setFlag("RockOnTile2");
        //setFlag("RockOnTile3");
        
        hideTextbox();
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
    	if (isFlagSet("RockOnTile1") && isFlagSet("RockOnTile2") && isFlagSet("RockOnTile3")) {
            setFlag("hasFinishedPuzzle");
    	}
        if (!isFlagSet("hasFinishedPuzzle")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
            PuzzleOneScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}