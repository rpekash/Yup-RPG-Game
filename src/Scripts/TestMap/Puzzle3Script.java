package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleThreeScreen;
import Screens.PuzzleTwoScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class Puzzle3Script extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("You Made it Out!");
        
        
        
    }

    @Override
    protected void cleanup() {
        setFlag("hasFinishedMaze");
        hideTextbox();
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasFinishedMaze")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
            PuzzleThreeScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}


