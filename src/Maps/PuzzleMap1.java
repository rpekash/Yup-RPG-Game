package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.TextTile;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.OJ;
import NPCs.Walrus;
import NPCs.UFO;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class PuzzleMap1 extends Map {

    public PuzzleMap1() {
        super("puzzle1.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        Rock rock1 = new Rock(getMapTile(2, 7).getLocation());
        //rock1.setExistenceFlag("onRock1");
        enhancedMapTiles.add(rock1);
        Rock rock2 = new Rock(getMapTile(11, 9).getLocation());
        //rock1.setExistenceFlag("onRock2");
        enhancedMapTiles.add(rock2);
        Rock rock3 = new Rock(getMapTile(9, 5).getLocation());
        //rock1.setExistenceFlag("onRock3");
        enhancedMapTiles.add(rock3);
        TextTile tile1 = new TextTile(getMapTile(4, 7).getLocation(), rock1);
        enhancedMapTiles.add(tile1);
        if (tile1.isOnTile()) {
        	this.flagManager.setFlag("onRock1");
        }
        TextTile tile2 = new TextTile(getMapTile(5, 8).getLocation(), rock2);
        enhancedMapTiles.add(tile2);
        if (tile2.isOnTile()) {
        	this.flagManager.setFlag("onRock2");
        }
        TextTile tile3 = new TextTile(getMapTile(11, 8).getLocation(), rock3);
        enhancedMapTiles.add(tile3);
        if (tile3.isOnTile()) {
        	this.flagManager.setFlag("onRock3");
        }
        return enhancedMapTiles;
    }

    
	@Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        /*
        Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur); */
        
        OJ oj = new OJ(3, getMapTile(12, 20).getLocation());
        oj.setInteractScript(new OJScript());
        npcs.add(oj);
        
        UFO ufo = new UFO(4, getMapTile(10,20).getLocation());
        ufo.setInteractScript(new UFOScript());
        npcs.add(ufo);

        return npcs;
    }

    /*
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    } */

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
    
   
}