	package Maps;

	import java.util.ArrayList;

import Engine.GraphicsHandler;
	import Engine.ImageLoader;
	import Game.ScreenCoordinator;
	import GameObject.ImageEffect;
	import GameObject.Sprite;
	import Level.Map;
	import Level.Player;
import Level.Trigger;
import Scripts.Puzzle4Scriptfinish;
import Tilesets.CommonTileset;
	import Utils.Colors;
	import Utils.Point;

public class WinningMap extends Map {

	    private Sprite cat;

	    public WinningMap(Player player, ScreenCoordinator screenCoordinator) {
	        super("winningscreen.txt", new CommonTileset(), player, screenCoordinator);
	    }
	    

	    @Override
	    public void draw(GraphicsHandler graphicsHandler) {
	        super.draw(graphicsHandler);
	    }
	}


