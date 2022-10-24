package EnhancedMapTiles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Utils.Direction;
import Utils.Point;

public class Spike extends EnhancedMapTile {
    public Spike(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Spike.png"), 16, 16), TileType.PASSABLE);
        this.affectedByTriggers = true;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (player.overlaps(this) && player.getPlayerState() == PlayerState.WALKING) {
            if (player.getCurrentWalkingXDirection() == Direction.LEFT) {
            	
                if (canMoveLeft(player)) {
                   
                }
            }
            else if (player.getCurrentWalkingXDirection() == Direction.RIGHT) {
                if (canMoveRight(player)) {
                    
                }
            }
             if (player.getCurrentWalkingYDirection() == Direction.UP) {
                if (canMoveUp(player)) {
                    
                }
            }
            else if (player.getCurrentWalkingYDirection() == Direction.DOWN) {
                if (canMoveDown(player)) {
                    
                }
            }
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
        Frame frame = new FrameBuilder(spriteSheet.getSprite(0, 0), 200)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build();
        
        
        return new GameObject(x, y, frame);
    }
}
