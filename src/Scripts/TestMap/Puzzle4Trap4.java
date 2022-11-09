package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Music.ClipMusicJavaUpdated;
import Screens.PlayLevelScreen;
import Screens.PuzzleTwoScreen;
import Utils.Point;


// trigger script at beginning of game to set that heavy emotional plot
public class Puzzle4Trap4 extends Script {
	 protected void setup() {
		 
	        player.takeDamage(10);
	        lockPlayer();

	        //showTextbox();
	        setWaitTime(1000);
	        addTextToTextboxQueue(Integer.toString(player.getHealth()));
	        Frame[] frame = new Frame[] {
            		new FrameBuilder(map.getTileset().getSubImage(11, 0), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(11, 1), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(11, 2), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
                    new FrameBuilder(map.getTileset().getSubImage(11, 1), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(11, 0), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build()
            };
            		
            Point location = map.getMapTile(3, 5).getLocation();



            MapTile mapTile = new MapTileBuilder(frame)
            		
                    .build(location.x, location.y);
            
            
            setMapTile(3, 5, mapTile);

         

	        unlockPlayer();
	     // change door to the open door map tile

	        
	       
	    }

	    @Override
	    protected void cleanup() {
	    	setFlag("hasHitSpike");
	        unlockPlayer();
	       // hideTextbox();
	        

	        
	    }

	    @Override
	    public ScriptState execute() {
	    	if (!isFlagSet("hasHitSpike")) {
	            start();
	            if (!isTextboxQueueEmpty()) {
	            	if(isWaitTimeUp()== true) {
	            		removeText();
	            	}
	            	
	                return ScriptState.RUNNING;
	                
	            }
	            ClipMusicJavaUpdated playMusic = new ClipMusicJavaUpdated();
	    		playMusic.playMusicInScreen("src/spikeSound.wav");
	            end();
	        }
	    	
	        return ScriptState.COMPLETED;
	    
	    }
	}