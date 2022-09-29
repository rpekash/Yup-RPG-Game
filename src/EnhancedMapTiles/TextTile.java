package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.IntersectableRectangle;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Utils.Direction;
import Utils.Point;

public class TextTile extends EnhancedMapTile {
	
		private Rock rock;
		private boolean flag;
	
	    public TextTile(Point location, Rock rock) {
	        super(location.x, location.y, new SpriteSheet(ImageLoader.load("grass-tile.png"), 16, 16), TileType.PASSABLE);
	        this.rock = rock;
	        flag = false;
	    }

	    @Override
	    public void update(Player player) {
	        super.update(player);
	        if (rock.overlaps(this) && flag == false) {
	            System.out.println("Hi!");
	            flag = true;
	        }
	    }
	    
	    @Override
	    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
	        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
	                .withScale(3)
	                .build();
	        return new GameObject(x, y, frame);
	    }
	    
	}


