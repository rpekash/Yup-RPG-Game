package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleTwoScreen;
import Utils.Point;

// trigger script at beginning of game to set that heavy emotional plot
public class SpikeScript extends Script {
	 protected void setup() {
	        lockPlayer();
	        showTextbox();
	        addTextToTextboxQueue( "You hit a Spike Trap!");
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
            		
            Point location = map.getMapTile(18, 20).getLocation();

            MapTile mapTile = new MapTileBuilder(frame)
            		
                    .build(location.x, location.y);

            setMapTile(18, 20, mapTile);
	        unlockPlayer();
	     // change door to the open door map tile

	        
	       
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