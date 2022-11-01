package Scripts.TestMap;


import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;

// script for talking to OJ npc
public class OJScript extends Script<NPC> {
	
	//protected ScreenCoordinator screenCoordinator;
    @Override
    protected void setup() {
    	
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue( "Hey, it's me, OJ. Obviously.");
        
        addTextToTextboxQueue( "...What do you mean I'm a walrus? Are you insulting \nme?");
        
        
        //entity.facePlayer(player);
        
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
       
        return ScriptState.COMPLETED;
    }
    
}
