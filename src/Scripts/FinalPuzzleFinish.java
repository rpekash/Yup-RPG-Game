package Scripts;

import Level.Script;
import Level.ScriptState;
import Music.ClipMusicJavaUpdated;
import Screens.FinalPuzzleScreen;
import Screens.FinalWinningScreen;
import Screens.PuzzleFourScreen;

public class FinalPuzzleFinish extends Script {
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
	            ClipMusicJavaUpdated playMusic = new ClipMusicJavaUpdated();
	    		playMusic.playMusicInScreen("src/tileSound2.wav");
	            end();
	            FinalPuzzleScreen.setCompleted(true);
	            FinalPuzzleScreen.goBackToLevel();
	        }
	        return ScriptState.COMPLETED;
	    }
}
