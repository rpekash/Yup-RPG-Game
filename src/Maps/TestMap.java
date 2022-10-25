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
import NPCs.Portal;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.Portal2Script;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.PortalScript;
import Scripts.TestMap.Puzzle4Script;
import Tilesets.CommonTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap(Player player) {
        super("test_map.txt", new CommonTileset(), player);
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        Rock rock = new Rock(getMapTile(2, 7).getLocation(), "Rock.png");
        enhancedMapTiles.add(rock);
        enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock));
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
        
        Portal portal = new Portal(5, getMapTile (5, 5).getLocation());
        portal.setInteractScript(new PortalScript());
        npcs.add(portal);
        
        
        Portal portal2 = new Portal(5, getMapTile (10, 5).getLocation());
        portal2.setInteractScript(new Portal2Script());
        npcs.add(portal2);
        
        Portal portalToPuzzleFour = new Portal(5, getMapTile (10, 15).getLocation());
        portalToPuzzleFour.setInteractScript(new Puzzle4Script());
        npcs.add(portalToPuzzleFour);
        
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
        
        //getMapTile(5,5).setInteractScript(new SimpleTextScript("You've discovered a mysterious portal!"));
    }
}