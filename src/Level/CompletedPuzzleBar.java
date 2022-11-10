package Level;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Game.PuzzleIndex;
import Game.ScreenCoordinator;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

public class CompletedPuzzleBar {
	protected boolean isActive = true;
	protected final int x = 22;
	protected final int bottomY = 460;
	protected final int topY = 22;
	protected final int fontX = 35;
	protected final int fontBottomY = 500;
	protected final int fontTopY = 62;
	protected final int width = 750;
	protected final int height = 100;
	protected SpriteFont completedPuzzles;
    protected ScreenCoordinator screenCoordinator;

    private KeyLocker keyLocker = new KeyLocker();
	private Map map;
    private Key interactKey = Key.L;
	private Player player;
    protected JLabel countLabel;
    protected Font bigFont = new Font("Serif", Font.BOLD, 18);


	public CompletedPuzzleBar(Map map, ScreenCoordinator screenCoordinator) {
		this.map = map;
		this.screenCoordinator = screenCoordinator;

	}
	
	 public void update() {
	    	
    	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
             keyLocker.lockKey(interactKey);
         }
    	 else if (Keyboard.isKeyUp(interactKey)) {
             keyLocker.unlockKey(interactKey);
         }
	
	
	 }
	 
	 
	 public void draw(GraphicsHandler graphicsHandler,ScreenCoordinator screenCoordinator) {
	    	int completedPuzzleY;
		 if (!map.getCamera().isAtBottomOfMap()) {
			 completedPuzzleY = topY;
	        }
        else {
        	completedPuzzleY = topY;
        }
	 
//    	graphicsHandler.drawFilledRectangleWithBorder(545, completedPuzzleY, 200, 35, Color.cyan, Color.black, 2);
	        	
    	if (screenCoordinator != null) {
		    completedPuzzles = new SpriteFont("PuzzleTracker \n"+screenCoordinator.numberOfPuzzlesCompleted()+"/"+PuzzleIndex.NUMBER_OF_PUZZLES, 552, 47, "Monospaced", 30, new Color(49, 207, 240));
	        completedPuzzles.setOutlineColor(Color.black);
	        completedPuzzles.setOutlineThickness(10);
		    completedPuzzles.setColor(Color.white);
		    completedPuzzles.setFontSize(20);
		    completedPuzzles.draw(graphicsHandler);
		}
		else {
			completedPuzzles = new SpriteFont("PuzzleTracker \n"+"Null"+"/"+PuzzleIndex.NUMBER_OF_PUZZLES, 552, 47, "Monospaced", 30, new Color(49, 207, 240));
	        completedPuzzles.setOutlineColor(Color.black);
	        completedPuzzles.setOutlineThickness(10);
		    completedPuzzles.setColor(Color.white);
		    completedPuzzles.setFontSize(20);
		    completedPuzzles.draw(graphicsHandler);
		    
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
	    
	    public void setScreenCoordinator(ScreenCoordinator screenCoordinator) {
	    	this.screenCoordinator = screenCoordinator;
	    }
	    
	    public ScreenCoordinator getScreenCoordinator() {
	    	return this.screenCoordinator;
	    }
	 
	 
	 
	 
}
