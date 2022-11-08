package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

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
    protected Timer timer;
    protected JLabel countLabel;
    protected int minutes, seconds;
    protected Font cFont = new Font("Arial", Font.PLAIN, 50);
    protected boolean isRunning;
    protected String ddSec, ddMin;
    protected DecimalFormat dForm = new DecimalFormat("00");
    private static Boolean completed = false;
    //protected Textbox winBox;

    public PuzzleOneScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        //flagManager.addFlag("RockOnTile1", false);
        //flagManager.addFlag("RockOnTile2", false);
        //flagManager.addFlag("RockOnTile3", false);

        // define/setup map
        this.map = new PuzzleMap1(null);
       // map.reset();
        map.setFlagManager(flagManager);

        // setup player
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y,screenCoordinator);
        this.player.setMap(map);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
        this.puzzleOneScreenState = PuzzleOneScreenState.RUNNING;
        this.player.setFacingDirection(Direction.LEFT);
        
        map.setPlayer(player);
        map.getHealthbar().setPlayer(player);
        
        this.countLabel = new JLabel("");
        this.countLabel.setBounds(545, 402, 100, 100);
        this.countLabel.setHorizontalAlignment(JLabel.CENTER);
        this.countLabel.setFont(cFont);
        
        countLabel.setText("0:30");
        seconds = 0;
        minutes = 1;
        ddSec = dForm.format(seconds);
        isRunning = true;
        
        

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
        
        puzzleTimer();
        timer.start();
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
            case PUZZLE_FAILED:
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
        if (!isRunning) {
        	puzzleOneScreenState = PuzzleOneScreenState.PUZZLE_FAILED;
        	PuzzleOneScreen.goBackToLevel();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (puzzleOneScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                graphicsHandler.drawString(minutes + ":" + ddSec, 100, 100, cFont, Color.BLACK);
                break;
            case PUZZLE_COMPLETED:
            	//winScreen.draw(graphicsHandler);
                break;
            case PUZZLE_FAILED:
            	//winScreen.draw(graphicsHandler);
                break;
        }
    }

    public static  void setCompleted(Boolean complete) {
    	completed = complete;
    }
    public static boolean getCompleted() {
    	return completed;
    }
    
    public PuzzleOneScreenState getoneLevelScreenState() {
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
        RUNNING, PUZZLE_COMPLETED, PUZZLE_FAILED
    }
    
    public void puzzleTimer() {
    	timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				ddSec = dForm.format(seconds);
				countLabel.setText(minutes + ":" + ddSec);
				/*if (seconds > 0 && minutes > 0) {
					seconds--;
					ddSec = dForm.format(seconds);
					countLabel.setText(minutes + ":" + ddSec);
				} else if (seconds == 0 && minutes > 0) {
					minutes--;
					seconds = 59;
					ddSec = dForm.format(seconds);
					countLabel.setText(minutes + ":" + ddSec);
				} else if (seconds == 0 && minutes == 0){
					isRunning = false;
				}*/
				if (seconds == -1) {
					seconds = 59;
					minutes--;
					ddSec = dForm.format(seconds);
					countLabel.setText(minutes + ":" + ddSec);
				}
				if (minutes == 0 && seconds == 0) {
					timer.stop();
					isRunning = false;
				}
				
			}
		});
    }
    
}
