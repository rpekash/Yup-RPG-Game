package Scripts.TestMap;


import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;
import Utils.Direction;

// script for talking to OJ npc
public class OJScript extends Script<NPC> {
	
	//protected ScreenCoordinator screenCoordinator;
    @Override
    protected void setup() {
    	
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue( "Hey, im Oj. Recently there have been portal appearing randomly and \n"
        		+ "sucking people into them. Can see whats in them?");
        
        addTextToTextboxQueue( "I think there is one over there.");
        entity.walk(Direction.RIGHT, 0);
        
        
       // entity.facePlayer(player);
        
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
