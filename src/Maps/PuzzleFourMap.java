
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
import Scripts.TestMap.ArowScript;
import Scripts.TestMap.Arrow2Script;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.GeneralSpikeScript;
import Scripts.TestMap.LostBallScript;
	import Scripts.TestMap.OJScript;
	import Scripts.TestMap.Puzzle2Script;
	import Scripts.TestMap.Puzzle3Script;
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
	        this.playerStartPosition = getMapTile(14, 5).getLocation();
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
	        triggers.add(new Trigger(20, 1190, 30, 70, new Puzzle2Script(), "hasFinishedMaze"));
	        triggers.add(new Trigger(2, 3, 5, 40, new GeneralSpikeScript(), "hasHitSpike"));
	        triggers.add(new Trigger(455, 1205, 5, 40, new Spike2Script(), "hasHitSpike2"));
	        triggers.add(new Trigger(570, 1085, 50, 50, new ArowScript(), "hasHitArrow"));
	        triggers.add(new Trigger(100, 900, 20, 20, new Arrow2Script(), "hasHitArrow2"));
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



