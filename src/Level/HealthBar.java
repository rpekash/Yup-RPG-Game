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
    protected boolean isActive;
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

    public HealthBar(Map map) {
        this.map = map;
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
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
            if (!map.getCamera().isAtBottomOfMap()) {
                graphicsHandler.drawFilledRectangleWithBorder(x, topY, 350, 30, Color.green, Color.white, 2);
            }
            else {
                graphicsHandler.drawFilledRectangleWithBorder(x, topY, 350, 30, Color.green, Color.white, 2);
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
}