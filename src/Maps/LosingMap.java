	package Maps;

	import Engine.GraphicsHandler;
	import Engine.ImageLoader;
	import Game.ScreenCoordinator;
	import GameObject.ImageEffect;
	import GameObject.Sprite;
	import Level.Map;
	import Level.Player;
	import Tilesets.CommonTileset;
	import Utils.Colors;
	import Utils.Point;

public class LosingMap extends Map {

	    private Sprite cat;

	    public LosingMap(Player player, ScreenCoordinator screenCoordinator) {
	        super("losingscreen.txt", new CommonTileset(), player, screenCoordinator);
	    }

	    @Override
	    public void draw(GraphicsHandler graphicsHandler) {
	        super.draw(graphicsHandler);
	    }
	}

