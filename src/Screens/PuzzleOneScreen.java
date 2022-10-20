package Screens;

import Engine.GraphicsHandler;

import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.PuzzleMap1;
import Maps.TestMap;
import Music.LoopMusicJavaUpdated;
import Players.Cat;
import Scripts.TestMap.Puzzle1Script;
//import Screens.PlayLevelScreen.PlayLevelScreenState;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PuzzleOneScreen extends Screen {
    protected static ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PuzzleOneScreenState puzzleOneScreenState;
    protected FlagManager flagManager;
    protected WinScreen winScreen;
    //protected Textbox winBox;

    public PuzzleOneScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("RockOnTile1", false);
        flagManager.addFlag("RockOnTile2", false);
        flagManager.addFlag("RockOnTile3", false);

        // define/setup map
        this.map = new PuzzleMap1();
        map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.puzzleOneScreenState = PuzzleOneScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);

        //this.winBox.addText("You completed the Puzzle!");
        
        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());
        
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
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (puzzleOneScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case PUZZLE_COMPLETED:
            	//winScreen.update();
                break;
        }
        if (//map.getFlagManager().isFlagSet("RockOnTile1") && 
        		/*map.getFlagManager().isFlagSet("RockOnTile2") && map.getFlagManager().isFlagSet("RockOnTile3") &&*/ 
        		map.getActiveEnhancedMapTiles().get(0).overlaps(map.getActiveEnhancedMapTiles().get(3))
        				&& map.getActiveEnhancedMapTiles().get(1).overlaps(map.getActiveEnhancedMapTiles().get(4))
        				&& map.getActiveEnhancedMapTiles().get(2).overlaps(map.getActiveEnhancedMapTiles().get(5))) {
        	new Puzzle1Script();
            puzzleOneScreenState = PuzzleOneScreenState.PUZZLE_COMPLETED;
            PuzzleOneScreen.goBackToLevel();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (puzzleOneScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case PUZZLE_COMPLETED:
            	
            	//winScreen.draw(graphicsHandler);
                break;
        }
    }

    public PuzzleOneScreenState getPlayLevelScreenState() {
        return puzzleOneScreenState;
    }


    public void resetPuzzle() {
        initialize();
    }

    public static void goBackToLevel() {
        screenCoordinator.setGameState(GameState.LEVEL);
    }

    // This enum represents the different states this screen can be in
    public enum PuzzleOneScreenState {
        RUNNING, PUZZLE_COMPLETED
    }
}
