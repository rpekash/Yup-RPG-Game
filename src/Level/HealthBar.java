package Level;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class HealthBar {
    protected boolean isActive = true;
    protected final int x = 22;
    protected final int bottomY = 460;
    protected final int topY = 22;
    protected final int fontX = 35;
    protected final int fontBottomY = 500;
    protected final int fontTopY = 62;
    protected final int width = 750;
    protected final int height = 100;

    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.H;
	private Player player;

    public HealthBar(Map map, Player player) {
        this.map = map;
        if(player == null) {
        	System.out.println("Helath bar constructor not working");
        }
        else {
			System.out.println("health bar constructor works");
		}
        this.player = player;
    }

    public void update() {
    	
    	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
             keyLocker.lockKey(interactKey);
         }
    	 else if (Keyboard.isKeyUp(interactKey)) {
             keyLocker.unlockKey(interactKey);
         }

    	 
    }

    public void draw(GraphicsHandler graphicsHandler) {
//    	if(player == null) {
//   		System.out.println("Player is null");
//    		return;
//    	}
    
        // if camera is at bottom of screen, health bar is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
    	int healthBarY;
        if (!map.getCamera().isAtBottomOfMap()) {
        	healthBarY = bottomY;
        }
        else {
        	healthBarY = topY;
        }
        int fullLength = 350;
        graphicsHandler.drawFilledRectangleWithBorder(x, healthBarY, fullLength, 30, Color.gray, Color.white, 2);
        
        if(player != null) {
        	 int currentLength = fullLength*(player.getHealth()/100);
             graphicsHandler.drawFilledRectangle(x, healthBarY+4, currentLength, 20, Color.green);
        }
    	
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
    
    public Key getInteractKey()
    {
    	return this.interactKey;
    }

    public KeyLocker getKeyLocker()
    {
    	return keyLocker;
    }
    
    public void setPlayer(Player player) {
    	this.player = player;
    }
    
    public Player getPlayer() {
    	return this.player;
    }
}