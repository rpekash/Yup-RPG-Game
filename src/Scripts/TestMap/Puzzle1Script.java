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

    	/*if (map.getFlagManager().isFlagSet("RockOnTile1") && map.getFlagManager().isFlagSet("RockOnTile2") 
    			&& map.getFlagManager().isFlagSet("RockOnTile3")) {
            setFlag("hasFinishedPuzzle");
    	}*/
        setFlag("hasFinishedPuzzle1");
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasFinishedPuzzle1")) {
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