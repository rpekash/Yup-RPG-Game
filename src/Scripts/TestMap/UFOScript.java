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
    	int x = 0;
        start();
        while (!isTextboxQueueEmpty()) {
        	if (x == 0) {
        		entity.walk(Direction.LEFT, 1);
        		x=x++;
        	}
        	else if (x == 1) {
        		entity.walk(Direction.UP, 1);
            	x=x++;
        	}
        	else if (x == 2) {
        		entity.walk(Direction.RIGHT, 1);
            	x=x++;
        	}
        	else if (x == 3) {
        		entity.walk(Direction.UP, 1);
            	x=x++;
        	}
            return ScriptState.RUNNING;
        }
        end();
        //PlayLevelScreen.goToPuzzleOne();
        return ScriptState.COMPLETED;
    }
}
