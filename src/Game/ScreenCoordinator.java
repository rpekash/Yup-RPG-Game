package Game;

import Engine.DefaultScreen;
import Engine.GameWindow;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.CreditsScreen;
import Screens.FinalPuzzleScreen;
import Screens.FinalWinningScreen;
import Screens.HowToPlayScreen;
import Screens.LosingScreen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;
import Screens.PuzzleFourScreen;
import Screens.PuzzleOneScreen;
import Screens.PuzzleThreeScreen;
import Screens.PuzzleTwoScreen;
import Screens.WinningScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	
	
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;
//	private GamePanel gamePanel;
	private GameWindow gameWindow;
	
	public ScreenCoordinator(GameWindow gameWindow) {
	this.gameWindow = gameWindow;	
	}

	public boolean[] completedPuzzles = new boolean[PuzzleIndex.NUMBER_OF_PUZZLES];
	public boolean[] puzzleJustCompleted = new boolean[PuzzleIndex.NUMBER_OF_PUZZLES];
	
	// create constructor and link 
	public GameState getGameState() {
		return gameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case PUZZLE_1:
						currentScreen = new PuzzleOneScreen(this);
						break;
					case PUZZLE_2:
						currentScreen = new PuzzleTwoScreen(this);
						break;
					case PUZZLE_3:
						currentScreen = new PuzzleThreeScreen(this);
						break;
					case PUZZLE_4:
						currentScreen = new PuzzleFourScreen(this);
						break;
					case PUZZLE_final:
						currentScreen = new FinalPuzzleScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
						
					case HOWTOPLAY:
						currentScreen = new HowToPlayScreen(this);
						break;

					case LOSING_SCREEN:
						currentScreen = new LosingScreen(this);
						break;
					case WINNING_SCREEN:
						currentScreen = new WinningScreen(this);

						break;
					case FINAL_WINNING_SCREEN:
						currentScreen = new FinalWinningScreen(this, gameWindow);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}
	
	   public int numberOfPuzzlesCompleted() {
	    	int puzzlesCompletedCounter = 0;
	    	for(int i = 0; i < PuzzleIndex.NUMBER_OF_PUZZLES; i++ ) {
	    		if (completedPuzzles[i] == true) {
	        		puzzlesCompletedCounter++;

	    		}
	    	}
	    	return puzzlesCompletedCounter;
	    }
	   
	   public void puzzleCompleted(int puzzle) {
	    	for(int i = 0; i < PuzzleIndex.NUMBER_OF_PUZZLES; i++ ) {
	    		if (completedPuzzles[i] == true) {
		    		puzzleJustCompleted[i] = false;
	    		}
	    	}
	    	puzzleJustCompleted[puzzle] = true;
	    }


	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}