package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.Spike;
import EnhancedMapTiles.TextTile;
import Game.ScreenCoordinator;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.OJ;
import NPCs.Walrus;
import NPCs.UFO;

import NPCs.SpikeTrap;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ArowScript;
import Scripts.TestMap.Arrow2Script;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.Puzzle2Script;
import Scripts.TestMap.Spike2Script;
import Scripts.TestMap.SpikeScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Utils.Direction;

import java.util.ArrayList;


import Enemies.Ufo;



// Represents a test map to be used in a level
public class FinalPuzzleMap extends Map {
	Boolean run = true;
    public FinalPuzzleMap(Player player, ScreenCoordinator screenCoordinator ) {
        super("finalpuzzle.txt", new CommonTileset(), player, screenCoordinator);
        this.playerStartPosition = getMapTile(1, 3).getLocation();
        
    }
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Ufo(getMapTile(4, 7).getLocation().addY(30), Direction.LEFT));
        
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
//        Rock rock = new Rock(getMapTile(2, 7).getLocation(), "Rock.png");
//        enhancedMapTiles.add(rock);
        
       // enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock));
        return enhancedMapTiles;
    }
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        
        
      /* UFO ufo = new UFO(4, getMapTile(4,8).getLocation());
        ufo.setInteractScript(new UFOScript());
        npcs.add(ufo);*/
        
        
        
        return npcs;
    }

    
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(393, 395, 30, 55, new Puzzle2Script(), "hasFinishedMaze"));
        
        return triggers;
    } 

    @Override
    public void loadScripts() {
       
    }
}

