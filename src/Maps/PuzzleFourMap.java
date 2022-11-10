
	package Maps;

	import EnhancedMapTiles.Rock;
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
import Scripts.Puzzle4Scriptfinish;
import Scripts.SimpleTextScript;
import Scripts.TestMap.ArowScript;
import Scripts.TestMap.Arrow2Script;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.GeneralSpikeScript;
import Scripts.TestMap.LostBallScript;
	import Scripts.TestMap.OJScript;
	import Scripts.TestMap.Puzzle2Script;
	import Scripts.TestMap.Puzzle3Script;
import Scripts.TestMap.Puzzle4Script;
import Scripts.TestMap.Puzzle4Spike;
import Scripts.TestMap.Puzzle4Spike21;
import Scripts.TestMap.Puzzle4Spike22;
import Scripts.TestMap.Puzzle4Spike23;
import Scripts.TestMap.Puzzle4Spike24;
import Scripts.TestMap.Puzzle4Trap1;
import Scripts.TestMap.Puzzle4Trap10;
import Scripts.TestMap.Puzzle4Trap11;
import Scripts.TestMap.Puzzle4Trap12;
import Scripts.TestMap.Puzzle4Trap13;
import Scripts.TestMap.Puzzle4Trap14;
import Scripts.TestMap.Puzzle4Trap15;
import Scripts.TestMap.Puzzle4Trap16;
import Scripts.TestMap.Puzzle4Trap17;
import Scripts.TestMap.Puzzle4Trap18;
import Scripts.TestMap.Puzzle4Trap19;
import Scripts.TestMap.Puzzle4Trap20;
import Scripts.TestMap.Puzzle4Trap3;
import Scripts.TestMap.Puzzle4Trap4;
import Scripts.TestMap.Puzzle4Trap5;
import Scripts.TestMap.Puzzle4Trap6;
import Scripts.TestMap.Puzzle4Trap7;
import Scripts.TestMap.Puzzle4Trap8;
import Scripts.TestMap.Puzzle4Trap9;
import Scripts.TestMap.PuzzleTrap2;
import Scripts.TestMap.Spike2Script;
import Scripts.TestMap.SpikeScript;
import Scripts.TestMap.TreeScript;
	import Scripts.TestMap.UFOScript;
	import Scripts.TestMap.WalrusScript;
	import Tilesets.CommonTileset;

	import java.util.ArrayList;

	// Represents a test map to be used in a level
	public class PuzzleFourMap extends Map {

	    public PuzzleFourMap(Player player, ScreenCoordinator screenCoordinator) {
	        super("puzzle4.txt", new CommonTileset(), player, screenCoordinator);
	        this.playerStartPosition = getMapTile(7, 1).getLocation();
	    }

	    @Override
	    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

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
	        triggers.add(new Trigger(50, 900, 700, 900, new Puzzle4Scriptfinish(), "hasFinishedMaze"));
//	        triggers.add(new Trigger(885, 965, 5, 40, new SpikeScript(), "hasHitSpike"));
	        
	        // 1st ROW
	        triggers.add(new Trigger(150, 250, 30, 30, new Puzzle4Trap4(), "hasHitSpike"));
	        triggers.add(new Trigger(390, 250, 30, 30, new Puzzle4Trap5(), "hasHitSpike"));
	        triggers.add(new Trigger(440, 250, 30, 30, new Puzzle4Trap6(), "hasHitSpike"));
	        
	        // 2th ROW
	        triggers.add(new Trigger(527, 345, 30, 30, new Puzzle4Trap10(), "hasHitSpike"));
	        triggers.add(new Trigger(440, 345, 30, 30, new Puzzle4Trap9(), "hasHitSpike"));
	        triggers.add(new Trigger(145, 345, 30, 30, new Puzzle4Trap8(), "hasHitSpike"));
	        triggers.add(new Trigger(100, 345, 30, 30, new Puzzle4Trap7(), "hasHitSpike"));
	        
	        // 3th ROW
	        triggers.add(new Trigger(145, 444, 30, 30, new Puzzle4Trap11(), "hasHitSpike"));
	        triggers.add(new Trigger(245, 444, 30, 30, new Puzzle4Trap12(), "hasHitSpike"));
	        triggers.add(new Trigger(340, 444, 30, 30, new Puzzle4Trap13(), "hasHitSpike"));

	        // 4th ROW
	        triggers.add(new Trigger(195, 534, 30, 30, new Puzzle4Trap14(), "hasHitSpike"));
	        triggers.add(new Trigger(290, 534, 30, 30, new Puzzle4Trap15(), "hasHitSpike"));
	        triggers.add(new Trigger(340, 534, 30, 30, new Puzzle4Trap16(), "hasHitSpike"));
	        triggers.add(new Trigger(578, 534, 30, 30, new Puzzle4Trap17(), "hasHitSpike"));
	        
	        // 5th ROW
	        triggers.add(new Trigger(100, 630, 30, 30, new Puzzle4Trap18(), "hasHitSpike"));
	        triggers.add(new Trigger(290, 630, 30, 30, new Puzzle4Trap19(), "hasHitSpike"));
	        triggers.add(new Trigger(443, 630, 30, 30, new Puzzle4Trap20(), "hasHitSpike"));
	        
	        // 6th ROW
	        triggers.add(new Trigger(145, 825, 30, 30, new Puzzle4Spike21(), "hasHitSpike"));
	        triggers.add(new Trigger(195, 825, 30, 30, new Puzzle4Spike22(), "hasHitSpike"));
	        triggers.add(new Trigger(530, 825, 30, 30, new Puzzle4Spike24(), "hasHitSpike"));
	        triggers.add(new Trigger(350, 825, 30, 30, new Puzzle4Spike23(), "hasHitSpike"));
	        
	   

	        
	   
	        
	       
	       
	        



	        return triggers;
	        
	    } 

	    @Override
	    public void loadScripts() {
//	       getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));
//
//	        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));
//
//	        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

	        getMapTile(2, 6).setInteractScript(new TreeScript());
	    }
	}



