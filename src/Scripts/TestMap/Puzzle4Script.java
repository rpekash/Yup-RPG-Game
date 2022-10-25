package Scripts.TestMap;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;

public class Puzzle4Script extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
        showTextbox();
        addTextToTextboxQueue( "You've discovered a mysterious portal!");
        addTextToTextboxQueue( "Uh oh, it's sucking you in");
        entity.facePlayer(player);
	}
	
	@Override
	protected void cleanup() {
	    unlockPlayer();
        hideTextbox();		
	}

	@Override
	protected ScriptState execute() {
		start();
	    if (!isTextboxQueueEmpty()) {        	
	        return ScriptState.RUNNING;       
	    } 
	    end();
	    PlayLevelScreen.goToPuzzleFour();
	    return ScriptState.COMPLETED;
	}
}
