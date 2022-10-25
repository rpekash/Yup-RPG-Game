package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.TextTile;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.OJ;
import NPCs.Walrus;
import NPCs.UFO;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.Puzzle2Script;
import Scripts.TestMap.Puzzle3Script;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class PuzzleThreeMap extends Map {

    public PuzzleThreeMap(Player player) {
        super("puzzle3.txt", new CommonTileset(), player);
        this.playerStartPosition = getMapTile(14, 5).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        Rock rock = new Rock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(rock);
        
        Rock rock1 = new Rock(getMapTile(3, 8).getLocation());
        enhancedMapTiles.add(rock1);
        
        Rock rock2 = new Rock(getMapTile(6, 9).getLocation());
        enhancedMapTiles.add(rock2);
        
        Rock rock3 = new Rock(getMapTile(7, 7).getLocation());
        enhancedMapTiles.add(rock3);
        
        Rock rock4 = new Rock(getMapTile(12, 2).getLocation());
        enhancedMapTiles.add(rock4);
        //enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock));
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
        
       /* OJ oj = new OJ(3, getMapTile(12, 20).getLocation());
        oj.setInteractScript(new OJScript());
        npcs.add(oj);
        
        UFO ufo = new UFO(4, getMapTile(10,20).getLocation());
        ufo.setInteractScript(new UFOScript());
        npcs.add(ufo);*/

        return npcs;
    }

    
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(1, 340, 40, 40, new Puzzle3Script(), "hasFinishedMaze"));
        
        return triggers;
    } 

    @Override
    public void loadScripts() {
       // getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        //getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        //getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}
