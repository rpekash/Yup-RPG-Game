package Screens;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Level.Player;
import Maps.LosingMap;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

public class LosingScreen extends Screen {
	protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont credits;
    protected Map background;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.SPACE;
	private Player player;
	

    public LosingScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        playGame = new SpriteFont("You Died, Try Again! Press Space to Respawn!", 200, 150, "Comic Sans", 20, new Color(49, 207, 240));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        background = new LosingMap(null, screenCoordinator);
        background.setAdjustCamera(false);
        keyTimer.setWaitTime(200);
        keyLocker.lockKey(Key.SPACE);
  
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
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        playGame.draw(graphicsHandler);
    }
}
