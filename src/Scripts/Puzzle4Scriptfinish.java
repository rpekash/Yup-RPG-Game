package Scripts;

import Level.Script;
import Level.ScriptState;
import Music.ClipMusicJavaUpdated;
import Screens.PuzzleFourScreen;
import Screens.PuzzleThreeScreen;

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
            ClipMusicJavaUpdated playMusic = new ClipMusicJavaUpdated();
    		playMusic.playMusicInScreen("src/tileSound2.wav");
            end();
            PuzzleFourScreen.setCompleted(true);
            PuzzleFourScreen.goBackToLevel();
        }
        return ScriptState.COMPLETED;
    }
}