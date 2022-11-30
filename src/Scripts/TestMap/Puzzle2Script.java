package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Music.ClipMusicJavaUpdated;
import Screens.PlayLevelScreen;
import Screens.PuzzleThreeScreen;
import Screens.PuzzleTwoScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class Puzzle2Script extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        
        
        
        
    }

    @Override
    protected void cleanup() {
        setFlag("hasFinishedPuzzle2");
  
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasFinishedPuzzle2")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
            ClipMusicJavaUpdated playMusic = new ClipMusicJavaUpdated();
    		playMusic.playMusicInScreen("src/tileSound2.wav");
            PuzzleTwoScreen.setCompleted(true);
            PuzzleTwoScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}

