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
import Music.ClipMusicJavaUpdated;
import Utils.Direction;
import Utils.Point;

public class TextTile extends EnhancedMapTile {
	
		protected String texture;
		private Rock rock;
		public boolean flag;
		protected ClipMusicJavaUpdated playMusic;
	
	    public TextTile(Point location, Rock rock, String texture) {
	        super(location.x, location.y, new SpriteSheet(ImageLoader.load(texture), 16, 16), TileType.PASSABLE);
	        this.texture = texture;
	        this.rock = rock;
	        flag = false;
	    }

	    @Override
	    public void update(Player player) {
	        super.update(player);
	        if (rock.overlaps(this) && flag == false) {
	            System.out.println("Hi!");
	            playMusic = new ClipMusicJavaUpdated();
        		playMusic.playMusicInScreen("src/tileSound2.wav");
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
	    
	    public boolean isOnTile() {
	    	return flag;
	    }
	    
	    
	    
	}


