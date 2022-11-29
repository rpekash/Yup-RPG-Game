package Screens;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.PuzzleIndex;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Music.LoopMusicJavaUpdated;
import Players.Cat;
import SpriteFont.SpriteFont;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen {
    protected static ScreenCoordinator screenCoordinator;
    protected Map map;
    protected static Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FlagManager flagManager;
    protected LoopMusicJavaUpdated playMusic;
    private static Boolean completed = false;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        PlayLevelScreen.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
    	  
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasFinishedPuzzle3", false);
        flagManager.addFlag("hasTalkedToOJ", false);
        flagManager.addFlag("hasTalkedToCowboy", false);
        flagManager.addFlag("hasTalkedToEm", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);

        // define/setup map
        this.map = new TestMap(null, screenCoordinator);
       // map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y,screenCoordinator);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);
        
        map.setPlayer(player);
        map.getHealthbar().setPlayer(player);
        map.getCompletedPuzzleBar().setScreenCoordinator(screenCoordinator);
        
        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        
        // setup map scripts to have references to the map and player
        for (MapTile mapTile : map.getMapTiles()) {
            if (mapTile.getInteractScript() != null) {
                mapTile.getInteractScript().setMap(map);
                mapTile.getInteractScript().setPlayer(player);
            }
        }
        for (NPC npc : map.getNPCs()) {
            if (npc.getInteractScript() != null) {
                npc.getInteractScript().setMap(map);
                npc.getInteractScript().setPlayer(player);
            }
        }
        for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
            if (enhancedMapTile.getInteractScript() != null) {
                enhancedMapTile.getInteractScript().setMap(map);
                enhancedMapTile.getInteractScript().setPlayer(player);
            }
        }
        for (Trigger trigger : map.getTriggers()) {
            if (trigger.getTriggerScript() != null) {
                trigger.getTriggerScript().setMap(map);
                trigger.getTriggerScript().setPlayer(player);
            }
        }

        winScreen = new WinScreen(this);
        
		playMusic = new LoopMusicJavaUpdated();
		playMusic.playMusicInScreen("src/SciFi.wav");
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
        }

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
       
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    public static  void setCompleted(Boolean complete) {
    	completed = complete;
    }
    public static boolean getCompleted() {
    	return completed;
    }

    public void resetLevel() {
        initialize();
    }
    
    public static void goToPuzzleOne() {
        screenCoordinator.setGameState(GameState.PUZZLE_1);
    }
    
    public static void goToPuzzleTwo() {
        screenCoordinator.setGameState(GameState.PUZZLE_2);
    }
    
    public static void goToPuzzleThree() {
        screenCoordinator.setGameState(GameState.PUZZLE_3);
    }
    
	public static void goToPuzzleFour() {
		 screenCoordinator.setGameState(GameState.PUZZLE_4);	
	}
	public static void goToFinalPuzzle() {
		if(player.hasCompletedPuzzles() == true) {
		 screenCoordinator.setGameState(GameState.PUZZLE_final);	
		}
		else {
			// Add Message For user to complete all puzzles.
			 screenCoordinator.setGameState(GameState.LEVEL);	
		}
	}
    
    
    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED
    }

	
}