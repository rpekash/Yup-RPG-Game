package Level;

import java.awt.Color;
import java.awt.Font;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Game.PuzzleIndex;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

public class completedPuzzleBar {
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
	
    private KeyLocker keyLocker = new KeyLocker();
	private Map map;
    private Key interactKey = Key.L;
	private Player player;
	
	public completedPuzzleBar(Map map, Player player) {
		this.map = map;
		this.player = player;  
		if (player != null) {
	        completedPuzzles = new SpriteFont(player.numberOfPuzzlesCompleted()+"/"+PuzzleIndex.NUMBER_OF_PUZZLES, 200, 150, "Comic Sans", 30, new Color(49, 207, 240));
	        completedPuzzles.setOutlineColor(Color.black);
	        completedPuzzles.setOutlineThickness(3);
		}
		else {
	        completedPuzzles = new SpriteFont(0+"/"+PuzzleIndex.NUMBER_OF_PUZZLES, 200, 150, "Comic Sans", 30, new Color(49, 207, 240));
	        completedPuzzles.setOutlineColor(Color.black);
	        completedPuzzles.setOutlineThickness(3);
	       
		}

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
		 
	      graphicsHandler.drawFilledRectangleWithBorder(650, 20, 100, 50, Color.black, Color.white, 2);
	        
	        if (player != null) {
	        	completedPuzzles.draw(graphicsHandler);
	        }
	 }
	 
	 
	 
	 
}
