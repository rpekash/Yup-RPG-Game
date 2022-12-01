package Screens;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Media;
import javax.swing.JPanel;

import Engine.GamePanel;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Level.Player;
import Maps.TitleScreenMap;
import Maps.WinningMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import Engine.GamePanel;

public class FinalWinningScreen extends Screen {
	 protected static ScreenCoordinator screenCoordinator;
	    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
	    protected int menuItemSelected = -1;
	    protected SpriteFont playGame;
	    protected SpriteFont credits;
	    protected Map background;
	    protected Stopwatch keyTimer = new Stopwatch();
	    protected int pointerLocationX, pointerLocationY;
	    private KeyLocker keyLocker = new KeyLocker();
	    private Map map;
	    private Key interactKey = Key.SPACE;
		private Player player;
		private GameWindow gameWindow;
		
		
	    public FinalWinningScreen(ScreenCoordinator screenCoordinator, GameWindow gameWindow) {
	        this.screenCoordinator = screenCoordinator;
	        this.gameWindow = gameWindow;
	    }

		public void initialize() {
	    	
            playGame = new SpriteFont("FINAL SCREEN", 150, 150, "Comic Sans", 20, new Color(49, 207, 240));
	        playGame.setOutlineColor(Color.black);
	        playGame.setOutlineThickness(3);
	        background = new WinningMap(null, screenCoordinator);
	        background.setAdjustCamera(false);
	    	
	        gameWindow.playVideo();
	        
		}

	    
	    public void update() {
	    	
	        // update background map (to play tile animations)
	        background.update(null);
	        if (Keyboard.isKeyUp(Key.SPACE)) {
	            keyLocker.unlockKey(Key.SPACE);
	        }
	        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
	        	keyLocker.unlockKey(interactKey);
		        screenCoordinator.setGameState(GameState.LEVEL);
	        }
 
	       	        
	    }
	    
	    public static void goBackToLevel() {
	   
	        screenCoordinator.setGameState(GameState.LEVEL);
	    }
	    
	    public void draw(GraphicsHandler graphicsHandler) {
	        background.draw(graphicsHandler);
	        playGame.draw(graphicsHandler);
	    }

}
