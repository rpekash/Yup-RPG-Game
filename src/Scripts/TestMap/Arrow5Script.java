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
public class Arrow5Script extends Script {
	 protected void setup() {
	        player.takeDamage(10);

	        lockPlayer();
	        //showTextbox();
	        setWaitTime(1000);
	        addTextToTextboxQueue(Integer.toString(player.getHealth()));

	        Frame[] trapframe = new Frame[] {
            		new FrameBuilder(map.getTileset().getSubImage(11, 4), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(11, 3), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build()
            };
            Point location = map.getMapTile(17, 16).getLocation();
            MapTile mapTile = new MapTileBuilder(trapframe)
                    .build(location.x, location.y);
            setMapTile(17, 16, mapTile);
            
            Frame grassFrame = new FrameBuilder(map.getTileset().getSubImage(8, 1), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build();
            Point locs = map.getMapTile(18, 16).getLocation();
            MapTile mapTile1 = new MapTileBuilder(grassFrame)
                    .withTileType(TileType.PASSABLE)
                    .build(locs.x, locs.y);
            setMapTile(18, 16, mapTile1);
            
	        Frame[] frame = new Frame[] {
            		new FrameBuilder(map.getTileset().getSubImage(12, 0), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build(),
            		new FrameBuilder(map.getTileset().getSubImage(12, 1), 500)
                    .withScale(map.getTileset().getTileScale())
                    .build()
            };
            Point loc = map.getMapTile(18, 16).getLocation();
            MapTile mapTiles = new MapTileBuilder(frame)
                    .build(loc.x, loc.y);
            setMapTile(18, 16, mapTiles);
            
            
            
            
	        unlockPlayer();
	     
	    }

	 @Override
	    protected void cleanup() {
	    	setFlag("hasHitArrow");
	        unlockPlayer();
	        
	       // hideTextbox();
	        Frame arrowFrame = new FrameBuilder(map.getTileset().getSubImage(11, 3), 0)
                 .withScale(map.getTileset().getTileScale())
                 .build();
         Point location = map.getMapTile(17, 16).getLocation();
         MapTile mapTile = new MapTileBuilder(arrowFrame)
                 .withTileType(TileType.NOT_PASSABLE)
                 .build(location.x, location.y);
         setMapTile(17, 16, mapTile);
         
         Frame grassFrame = new FrameBuilder(map.getTileset().getSubImage(8, 1), 0)
                 .withScale(map.getTileset().getTileScale())
                 .build();
         Point loc = map.getMapTile(18, 16).getLocation();
         MapTile mapTiles = new MapTileBuilder(grassFrame)
                 .withTileType(TileType.PASSABLE)
                 .build(loc.x, loc.y);
         setMapTile(18, 16, mapTiles);
         
         Frame arrow2Frame = new FrameBuilder(map.getTileset().getSubImage(12, 2), 0)
                 .withScale(map.getTileset().getTileScale())
                 .build();
         Point loc1 = map.getMapTile(19, 16).getLocation();
         MapTile mapTiles1 = new MapTileBuilder(arrow2Frame)
                 .withTileType(TileType.PASSABLE)
                 .build(loc1.x, loc1.y);
         setMapTile(19, 16, mapTiles1);
         
         

	        
	    }

	    @Override
	    public ScriptState execute() {
	    	if (!isFlagSet("hasHitArrow")) {
	            start();
	            if (!isTextboxQueueEmpty()) {
	            	if(isWaitTimeUp()== true) {
	            		removeText();
	            	}
	            	
	                return ScriptState.RUNNING;
	                
	            }
	            
	            end();
	        }
	    	
	        return ScriptState.COMPLETED;
	    }
	}

