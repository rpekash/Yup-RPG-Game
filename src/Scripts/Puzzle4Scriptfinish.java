package Scripts;

import Level.Script;
import Level.ScriptState;
import Screens.PuzzleFourScreen;

public class Puzzle4Scriptfinish extends Script {
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
            PuzzleFourScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}