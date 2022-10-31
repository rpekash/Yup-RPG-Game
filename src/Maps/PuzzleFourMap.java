
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

	    public PuzzleFourMap(Player player) {
	        super("puzzle4.txt", new CommonTileset(), player);
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
	        
	      //7th ROW
	        triggers.add(new Trigger(145, 825, 40, 40, new Puzzle4Spike(), "hasHitSpike2"));
	        triggers.add(new Trigger(195, 825, 40, 40, new Puzzle4Spike(), "hasHitSpike2"));
	        triggers.add(new Trigger(527, 825, 40, 40, new Puzzle4Spike(), "hasHitSpike2"));
	        triggers.add(new Trigger(337, 825, 40, 40, new Puzzle4Spike(), "hasHitSpike2"));
	        
	     // 6th ROW
	        triggers.add(new Trigger(100, 630, 40, 40, new Puzzle4Spike(), "hasHitSpike2"));
	        triggers.add(new Trigger(290, 630, 40, 40, new Puzzle4Trap19(), "hasHitSpike2"));
	        triggers.add(new Trigger(430, 630, 40, 40, new Puzzle4Trap18(), "hasHitSpike2"));
	        
	     // 5th ROW
	        triggers.add(new Trigger(195, 534, 40, 40, new Puzzle4Trap17(), "hasHitSpike2"));
	        triggers.add(new Trigger(290, 534, 40, 40, new Puzzle4Trap16(), "hasHitSpike2"));
	        triggers.add(new Trigger(340, 534, 40, 40, new Puzzle4Trap15(), "hasHitSpike2"));
	        triggers.add(new Trigger(578, 534, 40, 40, new Puzzle4Trap14(), "hasHitSpike2"));

	        
	        // 4th ROW
	        triggers.add(new Trigger(145, 434, 40, 40, new Puzzle4Trap13(), "hasHitSpike2"));
	        triggers.add(new Trigger(245, 434, 40, 40, new Puzzle4Trap12(), "hasHitSpike2"));
	        triggers.add(new Trigger(340, 434, 40, 40, new Puzzle4Trap11(), "hasHitSpike2"));
	        
	        // 3th ROW
	        triggers.add(new Trigger(145, 335, 40, 40, new Puzzle4Trap10(), "hasHitSpike2"));
	        triggers.add(new Trigger(100, 335, 40, 40, new Puzzle4Trap9(), "hasHitSpike2"));
	        triggers.add(new Trigger(527, 335, 40, 40, new Puzzle4Trap8(), "hasHitSpike2"));
	        triggers.add(new Trigger(440, 335, 40, 40, new Puzzle4Trap7(), "hasHitSpike2"));
	        
	        //2nd ROW
	        triggers.add(new Trigger(150, 240, 40, 40, new Puzzle4Trap6(), "hasHitSpike2"));
	        triggers.add(new Trigger(440, 240, 40, 40, new Puzzle4Trap5(), "hasHitSpike2"));
	        triggers.add(new Trigger(390, 240, 40, 40, new Puzzle4Trap4(), "hasHitSpike2"));
	        
	        //1nd ROW
	        triggers.add(new Trigger(435, 143, 40, 40, new Puzzle4Trap3(), "hasHitSpike2"));
	        triggers.add(new Trigger(345, 143, 40, 40, new PuzzleTrap2(), "hasHitSpike2"));
	        triggers.add(new Trigger(295, 143, 40, 40, new Puzzle4Trap1(), "hasHitSpike2"));



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



