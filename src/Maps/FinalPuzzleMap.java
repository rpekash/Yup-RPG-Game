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
import NPCs.Filmer;
import NPCs.OJ;
import NPCs.Walrus;
import NPCs.UFO;

import NPCs.SpikeTrap;
import Scripts.FinalPuzzleFinish;
import Scripts.Puzzle4Scriptfinish;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ArowScript;
import Scripts.TestMap.Arrow2Script;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.FilmerScript;
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
	
    public FinalPuzzleMap(Player player, ScreenCoordinator screenCoordinator ) {
        super("finalpuzzle.txt", new CommonTileset(), player, screenCoordinator);
        this.playerStartPosition = getMapTile(1, 3).getLocation();
        
    }
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Ufo(getMapTile(4, 7).getLocation(), Direction.LEFT));
        
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

        triggers.add(new Trigger(393, 395, 30, 55, new FinalPuzzleFinish(), "hasFinishedMaze"));
        
        //triggers.add(new Trigger(100, 900, 1900, 1900, new FinalPuzzleFinish(), "hasFinishedMaze"));


//        triggers.add(new Trigger(20, 1190, 30, 70, new Puzzle2Script(), "hasFinishedMaze"));
//        triggers.add(new Trigger(885, 965, 5, 40, new SpikeScript(), "hasHitSpike"));
//        triggers.add(new Trigger(455, 1205, 5, 40, new Spike2Script(), "hasHitSpike2"));
//        triggers.add(new Trigger(570, 1085, 50, 50, new ArowScript(), "hasHitArrow"));
//        triggers.add(new Trigger(275, 790, 20, 20, new Arrow2Script(), "hasHitArrow2"));

        return triggers;
    } 

    @Override
    public void loadScripts() {
       
    }
}

