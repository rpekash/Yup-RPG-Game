package Scripts.TestMap;
import Level.Script;
import Level.ScriptState;
import Music.ClipMusicJavaUpdated;
import Screens.PlayLevelScreen;
import Screens.PuzzleTwoScreen;

public class GoToFinalScript extends Script {
    @Override
    protected void setup() {
        lockPlayer();
       // showTextbox();
        //addTextToTextboxQueue("You found ");
        
        
        
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
            PlayLevelScreen.goToFinalPuzzle();
        }
        return ScriptState.COMPLETED;
    }
}

