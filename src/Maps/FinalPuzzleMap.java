package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.Spike;
import EnhancedMapTiles.TextTile;
import Game.ScreenCoordinator;
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

// Represents a test map to be used in a level
public class FinalPuzzleMap extends Map {
	Boolean run = true;
    public FinalPuzzleMap(Player player, ScreenCoordinator screenCoordinator ) {
        super("finalpuzzle.txt", new CommonTileset(), player, screenCoordinator);
        this.playerStartPosition = getMapTile(1, 3).getLocation();
        
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        Rock rock = new Rock(getMapTile(2, 7).getLocation(), "Rock.png");
        enhancedMapTiles.add(rock);
        
       // enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock));
        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        
        
        UFO ufo = new UFO(4, getMapTile(4,4).getLocation());
        ufo.setInteractScript(new UFOScript());
        npcs.add(ufo);
        
        
        
        return npcs;
    }

    
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(20, 1190, 30, 70, new Puzzle2Script(), "hasFinishedMaze"));
        triggers.add(new Trigger(885, 965, 5, 40, new SpikeScript(), "hasHitSpike"));
        triggers.add(new Trigger(455, 1205, 5, 40, new Spike2Script(), "hasHitSpike2"));
        triggers.add(new Trigger(570, 1085, 50, 50, new ArowScript(), "hasHitArrow"));
        triggers.add(new Trigger(275, 790, 20, 20, new Arrow2Script(), "hasHitArrow2"));
        return triggers;
    } 

    @Override
    public void loadScripts() {
       
    }
}

