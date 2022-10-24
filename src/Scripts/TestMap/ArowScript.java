package Scripts.TestMap;


import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Level.TileType;
import Screens.PlayLevelScreen;
import Screens.PuzzleTwoScreen;
import Utils.Point;

// trigger script at beginning of game to set that heavy emotional plot
public class ArowScript extends Script {
	 protected void setup() {
	        lockPlayer();
	        showTextbox();
	        addTextToTextboxQueue( "You hit a Spike Trap!");
	        
	        Frame[] trapframe = new Frame[] {
            		new FrameBuilder(map.getTileset().getSubImage(11, 4), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(11, 3), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build()
            		
            };
            Point location = map.getMapTile(11, 22).getLocation();

            MapTile mapTile = new MapTileBuilder(trapframe)
                    .build(location.x, location.y);

            setMapTile(11, 22, mapTile);
            
	        Frame[] frame = new Frame[] {
            		new FrameBuilder(map.getTileset().getSubImage(12, 0), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(12, 1), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build()
            		
            };
            		
            Point loc = map.getMapTile(12, 22).getLocation();

            MapTile mapTiles = new MapTileBuilder(frame)
            		
                    .build(loc.x, loc.y);

            setMapTile(12, 22, mapTiles);
	        unlockPlayer();
	     

	        
	       
	    }

	    @Override
	    protected void cleanup() {
	        unlockPlayer();
	        hideTextbox();
	        Frame arrowFrame = new FrameBuilder(map.getTileset().getSubImage(11, 3), 0)
                    .withScale(map.getTileset().getTileScale())
                    .build();
            Point location = map.getMapTile(11, 22).getLocation();

            MapTile mapTile = new MapTileBuilder(arrowFrame)
                    .withTileType(TileType.NOT_PASSABLE)
                    .build(location.x, location.y);

            setMapTile(11, 22, mapTile);
            
            Frame grassFrame = new FrameBuilder(map.getTileset().getSubImage(0, 0), 0)
                    .withScale(map.getTileset().getTileScale())
                    .build();
            Point loc = map.getMapTile(12, 22).getLocation();

            MapTile mapTiles = new MapTileBuilder(grassFrame)
                    .withTileType(TileType.PASSABLE)
                    .build(loc.x, loc.y);

            setMapTile(12, 22, mapTiles);

	        
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
