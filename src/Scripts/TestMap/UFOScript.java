package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.MapTile;
import Level.NPC;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.TileType;
import Screens.PlayLevelScreen;
import Utils.Direction;
import Utils.Point;

public class UFOScript extends Script<NPC> {
	   
	private int sequence = 0;
	private int amountMoved = 0;
	
    
	@Override
    protected void setup() {
        lockPlayer();
        showTextbox();
       
            showTextbox();
            
            addTextToTextboxQueue("I'm coming to get you.");
            entity.move(Direction.UP,5);
            entity.move(Direction.DOWN,5);
           
       
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
            unlockPlayer();
            hideTextbox();
        
         if (!isFlagSet("hasTalkedToUFO")) {
            if (sequence == 0) {
                hideTextbox();
                sequence++;
            }
            else if (sequence == 1) {
                sequence++;
            }
            else if (sequence == 2) {
                hideTextbox();
                sequence++;
            }
            else if (sequence == 3) {
                sequence++;
            }
            else if (sequence == 4) {
                sequence++;
            }
            else if (sequence == 5) {
                sequence++;

               
                Point location = player.getLocation();

               
                setFlag("hasTalkedToUFO");
                unlockPlayer();
            }
        }
        
    }
    public void update(Player player){
    	   
        //float xPosition = player.getX() - x;
        //float yPosition = player.getY() - y;
        
    }
    
    @Override
    public ScriptState execute() {

        start();
        while (!isTextboxQueueEmpty()) {
        	if (sequence == 0) {
        		entity.walk(Direction.UP, 2);
        		if (isWaitTimeUp()) {
        			System.out.println(isWaitTimeUp());
            		sequence++;
            	}
        	}
        	else if (sequence == 1) {
        		entity.walk(Direction.LEFT, 2);
        		if (!isWaitTimeUp()) {
            		sequence++;
            	}        	}
        	else if (sequence == 2) {
        		entity.walk(Direction.DOWN, 2);
        		if (!isWaitTimeUp()) {
            		sequence++;
            	}
            	
        	}
        	else if (sequence == 3) {
        		entity.walk(Direction.RIGHT, 10);
            	sequence++;
        	}
            return ScriptState.RUNNING;
        }
        end();
        //PlayLevelScreen.goToPuzzleOne();
        return ScriptState.COMPLETED;
    }
}
  
