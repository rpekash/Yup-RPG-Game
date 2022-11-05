package Scripts.TestMap;


import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;

// script for talking to the mysterious portal
public class FinalPortalScript extends Script<NPC> {
	
	//protected ScreenCoordinator screenCoordinator;
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
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
        	
            return ScriptState.RUNNING;
            
        }
        
        end();
        PlayLevelScreen.goToFinalPuzzle();
        return ScriptState.COMPLETED;
    }
    
}
