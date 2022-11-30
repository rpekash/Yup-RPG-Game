package Scripts;

import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleTwoScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class Puzzle2Script extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        
        
        
    }

    @Override
    protected void cleanup() {
        setFlag("hasFinishedMaze");
        
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
            PuzzleTwoScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}