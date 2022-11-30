package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.Timer;

import Engine.GraphicsHandler;

import Engine.Screen;
import Game.GameState;
import Game.PuzzleIndex;
import Game.ScreenCoordinator;
import Level.*;
import Maps.PuzzleThreeMap;
import Maps.PuzzleTwoMap;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

// This class is for when the platformer game is actually being played
public class PuzzleThreeScreen extends Screen {
    protected static ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PuzzleThreeScreenState puzzleThreeScreenState;
    protected FlagManager flagManager;
    private static Boolean completed = false;
    protected Timer timer;
    protected JLabel countLabel;
    protected int minutes, seconds;
    protected Font cFont = new Font("Arial", Font.PLAIN, 50);
    protected boolean isRunning;
    protected String ddSec, ddMin;
    protected DecimalFormat dForm = new DecimalFormat("00");

    public PuzzleThreeScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
    	
    	
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasFinishedPuzzle3", false);
        // define/setup map
        this.map = new PuzzleThreeMap(null,screenCoordinator);
        //map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, null);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.puzzleThreeScreenState = PuzzleThreeScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);
        
        map.setPlayer(player);
        map.getHealthbar().setPlayer(player);
        map.getCompletedPuzzleBar().setScreenCoordinator(screenCoordinator);

        
        this.countLabel = new JLabel("");
        this.countLabel.setBounds(545, 402, 100, 100);
        this.countLabel.setHorizontalAlignment(JLabel.CENTER);
        this.countLabel.setFont(cFont);
        
        countLabel.setText("0:30");
        seconds = 0;
        minutes = 1;
        ddSec = dForm.format(seconds);
        isRunning = true;

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
        puzzleTimer();
        timer.start();
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (puzzleThreeScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case PUZZLE_COMPLETED:
                break;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (puzzleThreeScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                graphicsHandler.drawString(minutes + ":" + ddSec, 100, 100, cFont, Color.BLACK);
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
    public PuzzleThreeScreenState getthreeLevelScreenState() {
        return puzzleThreeScreenState;
    }


    public void resetPuzzle() {
        initialize();
    }
    
    public static void goBackToLevel() {
    	screenCoordinator.completedPuzzles[PuzzleIndex.PUZZLE_THREE_INDEX] = true;
    	screenCoordinator.puzzleCompleted(PuzzleIndex.PUZZLE_THREE_INDEX);
        screenCoordinator.setGameState(GameState.LEVEL);
    }

    // This enum represents the different states this screen can be in
    private enum PuzzleThreeScreenState {
        RUNNING, PUZZLE_COMPLETED
    }
    
    public void puzzleTimer() {
    	timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				ddSec = dForm.format(seconds);
				countLabel.setText(minutes + ":" + ddSec);
				
				if (seconds == -1) {
					seconds = 59;
					minutes--;
					ddSec = dForm.format(seconds);
					countLabel.setText(minutes + ":" + ddSec);
				}
				if (minutes == 0 && seconds == 0) {
					timer.stop();
					isRunning = false;
		            screenCoordinator.puzzleCompleted(PuzzleIndex.PUZZLE_THREE_INDEX);
					screenCoordinator.setGameState(GameState.LEVEL);
					
				}
				
			}
		});
    }
}

