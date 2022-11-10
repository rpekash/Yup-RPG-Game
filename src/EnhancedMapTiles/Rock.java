package EnhancedMapTiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Builders.FrameBuilder;



import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Music.ClipMusicJavaUpdated;
import Music.LoopMusicJavaUpdated;
import Utils.Direction;
import Utils.Point;

// This class is for the end level gold box tile
// when the player touches it, it will tell the player that the level has been completed
public class Rock extends EnhancedMapTile {
	protected String tecture;
	protected ClipMusicJavaUpdated playMusic = new ClipMusicJavaUpdated();
	public boolean sFlag;
	protected Timer timer;
	
    public Rock(Point location, String tecture) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load(tecture), 16, 16), TileType.NOT_PASSABLE);
    	this.tecture = tecture;
        this.affectedByTriggers = true;
        sFlag = false;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (player.overlaps(this) && player.getPlayerState() == PlayerState.WALKING) {
    			rockTimer();
        		if (sFlag == false) {
        			playMusic.playMusicInScreen("src/rockPush.wav");
            		timer.start();
        			sFlag = true;
        		}	
            if (player.getCurrentWalkingXDirection() == Direction.LEFT) {
                if (canMoveLeft(player)) {
                    moveXHandleCollision(-1);
                }
            }
            
            else if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
                if (canMoveRight(player)) {
                    moveXHandleCollision(1);
                }
            }
             if (player.getCurrentWalkingYDirection() == Direction.UP) {
                if (canMoveUp(player)) {
                    moveYHandleCollision(-1);
                }
            }
            else if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
                if (canMoveDown(player)) {
                    moveYHandleCollision(1);
                }
            }
        } else {
        	sFlag = false;
        }
    }

    private boolean canMoveLeft(Player player) {
        return player.getBoundsX1() <= getBoundsX2() && player.getBoundsX2() > getBoundsX2() && canMoveX(player);
    }

    private boolean canMoveRight(Player player) {
        return player.getBoundsX2() >= getBoundsX1() && player.getBoundsX1() < getBoundsX1() && canMoveX(player);
    }

    private boolean canMoveX(Player player) {
        return (player.getBoundsY1() < getBoundsY2() && player.getBoundsY2() >= getBoundsY2()) ||
                (player.getBoundsY2() > getBoundsY1() && player.getBoundsY1() <= getBoundsY1()) ||
                (player.getBoundsY2() < getBoundsY2() && player.getBoundsY1() > getBoundsY1());
    }

    private boolean canMoveUp(Player player) {
        return player.getBoundsY1() <= getBoundsY2() && player.getBoundsY2() > getBoundsY2() && canMoveY(player);
    }

    private boolean canMoveDown(Player player) {
        return player.getBoundsY2() >= getBoundsY1() && player.getBoundsY1() < getBoundsY1() && canMoveY(player);
    }

    private boolean canMoveY(Player player) {
        return (player.getBoundsX1() < getBoundsX2() && player.getBoundsX2() >= getBoundsX2()) ||
                (player.getBoundsX2() > getBoundsX1() && player.getBoundsX1() <= getBoundsX1()) ||
                (player.getBoundsX2() < getBoundsX2() && player.getBoundsX1() > getBoundsX1());
    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(3)
                .build();
        return new GameObject(x, y, frame);
    }
    
    public void rockTimer() {
    	timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sFlag = true) {
					sFlag = false;
				} else {
					sFlag = true;
				}
				
			}
		});
    }
   
}
