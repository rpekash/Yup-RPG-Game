package Engine;

import GameObject.Rectangle;
import Music.LoopMusicJavaUpdated;
import SpriteFont.SpriteFont;
import Utils.Colors;
import Utils.Stopwatch;

import javax.swing.*;

import Game.GameState;
import Game.ScreenCoordinator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This is where the game loop starts
 * The JPanel uses a timer to continually call cycles of update and draw
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel
	// each screen has its own update and draw methods defined to handle a "section" of the game.
	private ScreenManager screenManager;

	// used to create the game loop and cycle between update and draw calls
	private Timer timer;

	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;
	
	protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
	private boolean doPaint = false;
	private boolean isGamePaused = false;
	private SpriteFont pauseLabel;
	private SpriteFont playLabel;
	private SpriteFont menuLabel;
	private SpriteFont plus;
	private SpriteFont minus;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.P;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected ScreenCoordinator screenCoordinator;
    private LoopMusicJavaUpdated mControl = new LoopMusicJavaUpdated();

	/*
	 * The JPanel and various important class instances are setup here
	 */
	public GamePanel() {
		super();
		this.setDoubleBuffered(true);
		
		this.screenCoordinator = new ScreenCoordinator();

		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();
		
		pauseLabel = new SpriteFont("PAUSE", 365, 240, "Comic Sans", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);
		
		playLabel = new SpriteFont("CONTINUE", 365, 290, "Comic Sans", 24, Color.white);
		playLabel.setOutlineColor(Color.black);
		playLabel.setOutlineThickness(2.0f);
		
		menuLabel = new SpriteFont("MENU", 365, 330, "Comic Sans", 24, Color.white);
		menuLabel.setOutlineColor(Color.black);
		menuLabel.setOutlineThickness(2.0f);
		
		plus = new SpriteFont("+", 365, 360, "Comic Sans", 24, Color.white);
		plus.setOutlineColor(Color.black);
		plus.setOutlineThickness(2.0f);
		
		minus = new SpriteFont("-", 325, 360, "Comic Sans", 24, Color.white);
		minus.setOutlineColor(Color.black);
		minus.setOutlineThickness(2.0f);

		// Every timer "tick" will call the update method as well as tell the JPanel to repaint
		// Remember that repaint "schedules" a paint rather than carries it out immediately
		// If the game is really laggy/slow, I would consider upping the FPS in the Config file.
		timer = new Timer(1000 / Config.FPS, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.setRepeats(true);
	}

	// this is called later after instantiation, and will initialize screenManager
	// this had to be done outside of the constructor because it needed to know the JPanel's width and height, which aren't available in the constructor
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
		doPaint = true;
	}

	// this starts the timer (the game loop is started here
	public void startGame() {
		timer.start();
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public void update() {
		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
		}
		
		if (Keyboard.isKeyUp(pauseKey)) {
			keyLocker.unlockKey(pauseKey);
		}

		if (!isGamePaused) {
			screenManager.update();
		}
		
		if (isGamePaused) {
			
			if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
		            keyTimer.reset();
		            currentMenuItemHovered++;
		        } else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
		            keyTimer.reset();
		            currentMenuItemHovered--;
		        }
			
			if (currentMenuItemHovered > 3) {
	            currentMenuItemHovered = 0;
	        } else if (currentMenuItemHovered < 0) {
	            currentMenuItemHovered = 3;
	        }
			
			if (currentMenuItemHovered == 0) {
				playLabel.setColor(new Color(255, 215, 0));
	            menuLabel.setColor(new Color(49, 207, 240));
	            plus.setColor(new Color(49, 207, 240));
	            minus.setColor(new Color(49, 207, 240));
	            pointerLocationX = 170;
	            pointerLocationY = 130;
			} else if (currentMenuItemHovered == 1) {
				playLabel.setColor(new Color(49, 207, 240));
	            menuLabel.setColor(new Color(255, 215, 0));
	            plus.setColor(new Color(49, 207, 240));
	            minus.setColor(new Color(49, 207, 240));
	            pointerLocationX = 170;
	            pointerLocationY = 230;
			} else if (currentMenuItemHovered == 2) {
				playLabel.setColor(new Color(49, 207, 240));
	            menuLabel.setColor(new Color(49, 207, 240));
	            plus.setColor(new Color(255, 215, 0));
	            minus.setColor(new Color(49, 207, 240));
	            pointerLocationX = 170;
	            pointerLocationY = 230;
			} else if (currentMenuItemHovered == 3) {
				playLabel.setColor(new Color(49, 207, 240));
	            menuLabel.setColor(new Color(49, 207, 240));
	            plus.setColor(new Color(49, 207, 240));
	            minus.setColor(new Color(255, 215, 0));
	            pointerLocationX = 170;
	            pointerLocationY = 230;
			}
			
			if (Keyboard.isKeyUp(Key.SPACE)) {
	            keyLocker.unlockKey(Key.SPACE);
	        }
			
	        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
	            menuItemSelected = currentMenuItemHovered;
	            if (menuItemSelected == 0) {
	            	isGamePaused = !isGamePaused;
	            } else if (menuItemSelected == 1) {
	                 screenCoordinator.setGameState(GameState.MENU);
	            	 isGamePaused = !isGamePaused;
				} else if (menuItemSelected == 2) {
	                 mControl.volumeUp();
				} else if (menuItemSelected == 3) {
	                 mControl.volumeDown();
				}
	        }
	        
	       
		}
	}

	public void draw() {
		screenManager.draw(graphicsHandler);

		// if game is paused, draw pause gfx over Screen gfx
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			menuLabel.draw(graphicsHandler);
			playLabel.draw(graphicsHandler);
			plus.draw(graphicsHandler);
			minus.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
			
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// every repaint call will schedule this method to be called
		// when called, it will setup the graphics handler and then call this class's draw method
		graphicsHandler.setGraphics((Graphics2D) g);
		if (doPaint) {
			draw();
		}
	}
}
