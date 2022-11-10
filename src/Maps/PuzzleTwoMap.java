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
import Scripts.TestMap.Arrow3Script;
import Scripts.TestMap.Arrow4Script;
import Scripts.TestMap.Arrow5Script;
import Scripts.TestMap.Arrow6Script;
import Scripts.TestMap.Arrow7Script;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.OJScript;
import Scripts.TestMap.Puzzle2Script;
import Scripts.TestMap.Spike2Script;
import Scripts.TestMap.Spike3Script;
import Scripts.TestMap.Spike4Script;
import Scripts.TestMap.Spike5Script;
import Scripts.TestMap.Spike6Script;
import Scripts.TestMap.Spike7Script;
import Scripts.TestMap.Spike8Script;
import Scripts.TestMap.SpikeScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.UFOScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;

import java.util.ArrayList;

// Represents a test map to be used in a level
public class PuzzleTwoMap extends Map {

    public PuzzleTwoMap(Player player, ScreenCoordinator screenCoordinator) {
        super("puzzle2.txt", new CommonTileset(), player, screenCoordinator);
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
       // Rock rock = new Rock(getMapTile(2, 7).getLocation(), "Rock.png");
       // enhancedMapTiles.add(rock);
        
       // enhancedMapTiles.add(new TextTile(getMapTile(4, 7).getLocation(), rock, "sand.png"));
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
        npcs.add(ufo);
        
        SpikeTrap spike = new SpikeTrap(4, getMapTile(20,20).getLocation());
        spike.setInteractScript(new SpikeScript());
        npcs.add(spike);*/
        return npcs;
    }

    
    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(20, 1190, 30, 70, new Puzzle2Script(), "hasFinishedMaze"));
        
        triggers.add(new Trigger(870, 965, 40, 40, new SpikeScript(), "hasHitSpike"));
        triggers.add(new Trigger(435, 1205, 40, 40, new Spike2Script(), "hasHitSpike2"));
        triggers.add(new Trigger(675, 580, 40, 40, new Spike3Script(), "hasHitSpike2"));
        triggers.add(new Trigger(868, 627, 40, 40, new Spike4Script(), "hasHitSpike2"));
        triggers.add(new Trigger(965, 100, 40, 40, new Spike5Script(), "hasHitSpike2"));
        triggers.add(new Trigger(580, 290, 40, 40, new Spike6Script(), "hasHitSpike2"));
        triggers.add(new Trigger(100, 245, 40, 40, new Spike7Script(), "hasHitSpike2"));
        triggers.add(new Trigger(195, 1348, 40, 40, new Spike8Script(), "hasHitSpike2"));
        
        
        triggers.add(new Trigger(570, 1085, 50, 50, new ArowScript(), "hasHitArrow"));
        triggers.add(new Trigger(275, 790, 20, 20, new Arrow2Script(), "hasHitArrow"));
        triggers.add(new Trigger(175, 400, 50, 50, new Arrow3Script(), "hasHitArrow"));
        triggers.add(new Trigger(80, 970, 50, 50, new Arrow4Script(), "hasHitArrow"));
        triggers.add(new Trigger(830, 770, 50, 50, new Arrow5Script(), "hasHitArrow"));
        triggers.add(new Trigger(740, 1360, 50, 50, new Arrow6Script(), "hasHitArrow"));
        triggers.add(new Trigger(550, 60, 50, 50, new Arrow7Script(), "hasHitArrow"));
       
        return triggers;
    } 

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

