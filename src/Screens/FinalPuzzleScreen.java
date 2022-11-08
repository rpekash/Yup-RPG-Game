package Screens;

import Engine.GraphicsHandler;

import Engine.Screen;
import Game.GameState;
import Game.PuzzleIndex;
import Game.ScreenCoordinator;
import Level.*;
import Maps.FinalPuzzleMap;
import Maps.PuzzleTwoMap;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class FinalPuzzleScreen extends Screen {
    protected static ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected FinalPuzzleScreenState finalpuzzleScreenState;
    protected FlagManager flagManager;
    private static Boolean completed;

    public FinalPuzzleScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();

        // define/setup map
        this.map = new FinalPuzzleMap(null);
        //map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, screenCoordinator);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.finalpuzzleScreenState = FinalPuzzleScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);
        map.getHealthbar().setPlayer(player);
        
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
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (finalpuzzleScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case PUZZLE_COMPLETED:
            	player.completedPuzzles[PuzzleIndex.PUZZLE_FINAL_INDEX] = true;
                break;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (finalpuzzleScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case PUZZLE_COMPLETED:
                break;
        }
    }
    
    public static  void setCompleted(Boolean complete) {
    	completed = complete;
    }
    public static boolean getCompleted() {
    	return completed;
    }

    public FinalPuzzleScreenState getFinalLevelScreenState() {
        return finalpuzzleScreenState;
    }


    public void resetPuzzle() {
        initialize();
    }
    
    public static void goBackToLevel() {
        screenCoordinator.setGameState(GameState.LEVEL);
    }

    // This enum represents the different states this screen can be in
    private enum FinalPuzzleScreenState {
        RUNNING, PUZZLE_COMPLETED
    }
}

