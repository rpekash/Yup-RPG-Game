package Maps;

import EnhancedMapTiles.Rock;
import EnhancedMapTiles.TextTile;
import Game.ScreenCoordinator;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Cowboy;
import NPCs.Dinosaur;
import NPCs.Emerald;
import NPCs.Filmer;
import NPCs.OJ;
import NPCs.Walrus;
import NPCs.UFO;
import NPCs.Portal;
import Scripts.SimpleTextScript;
import Scripts.TestMap.CowboyScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.EmeraldScript;
import Scripts.TestMap.FilmerScript;
import Scripts.TestMap.GoToFinalScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.Portal2Script;
import Scripts.TestMap.Portal3Script;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.PortalScript;
import Scripts.TestMap.Puzzle4Script;
import Tilesets.CommonTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap(Player player, ScreenCoordinator screenCoordinator) {
        super("test_map.txt", new CommonTileset(), player, screenCoordinator);
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
//        Rock rock = new Rock(getMapTile(2, 7).getLocation(), "Rock.png");
//        enhancedMapTiles.add(rock);
        
//        enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock, "sand.png"));
        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        
        /* 	Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);
        
        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur); */

       // OJ oj = new OJ(3, getMapTile(15, 20).getLocation());

        OJ oj = new OJ(3, getMapTile(15, 20).getLocation());
        oj.setInteractScript(new OJScript());
        npcs.add(oj);
        
        Filmer filmer = new Filmer(3, getMapTile(11, 11).getLocation());
        filmer.setInteractScript(new FilmerScript());
        npcs.add(filmer);
        
        Emerald em = new Emerald(3, getMapTile(4, 25).getLocation());
        em.setInteractScript(new EmeraldScript());
        npcs.add(em);
        
        Cowboy cowboy = new Cowboy(3, getMapTile(6, 9).getLocation());
        cowboy.setInteractScript(new CowboyScript());
        npcs.add(cowboy);
        
       
        
        Portal portal = new Portal(5, getMapTile (5, 5).getLocation());
        portal.setInteractScript(new PortalScript());
        npcs.add(portal);
        
        Portal p1portal = new Portal(5, getMapTile (10, 25).getLocation());
        p1portal.setInteractScript(new Portal3Script());
        npcs.add(p1portal);
        
        Portal portal2 = new Portal(5, getMapTile (10, 5).getLocation());
        portal2.setInteractScript(new Portal2Script());
        npcs.add(portal2);
        
        Portal portal4 = new Portal(5, getMapTile (10, 15).getLocation());
        portal4.setInteractScript(new Puzzle4Script());
        npcs.add(portal4);
        
        
        
        return npcs;
    }

    
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(245, 140, 40, 40, new GoToFinalScript(), "hasFinishedMaze"));
       
        return triggers;
    } 

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
        
        //getMapTile(5,5).setInteractScript(new SimpleTextScript("You've discovered a mysterious portal!"));
    }
}