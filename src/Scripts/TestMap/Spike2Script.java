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
public class Spike2Script extends Script {
	 protected void setup() {
	        player.takeDamage(10);

	        lockPlayer();
	        setWaitTime(1000);
	      //  showTextbox();
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
            		
            Point location = map.getMapTile(9, 25).getLocation();

            MapTile mapTile = new MapTileBuilder(frame)
            		
                    .build(location.x, location.y);

            setMapTile(9, 25, mapTile);
	        unlockPlayer();
            
	     // change door to the open door map tile

	        
	       
	    }

	 @Override
	    protected void cleanup() {
	    	setFlag("hasHitSpike2");
	        unlockPlayer();
	       // hideTextbox();
	        

	        
	    }

	    @Override
	    public ScriptState execute() {
	    	if (!isFlagSet("hasHitSpike2")) {
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