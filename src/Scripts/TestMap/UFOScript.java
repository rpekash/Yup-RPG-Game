package Scripts.TestMap;

import Level.NPC;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Utils.Direction;

public class UFOScript extends Script<NPC> {
	   
	private int sequence = 0;
	private int amountMoved = 0;
	
    
	@Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("I'm coming to get you.");
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        
    }
    public void update(Player player){
    	   
        //float xPosition = player.getX() - x;
        //float yPosition = player.getY() - y;
        
    }
    
    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
        	
        	entity.walk(Direction.DOWN, 1);
        	
            return ScriptState.RUNNING;
        }
        end();
        //PlayLevelScreen.goToPuzzleOne();
        return ScriptState.COMPLETED;
    }
}
