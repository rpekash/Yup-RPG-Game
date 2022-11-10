package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Direction;
import Utils.Point;

import java.util.HashMap;
import java.util.Random;

import javax.swing.text.html.parser.Entity;
import javax.tools.DocumentationTool.Location;

public class UFO extends NPC {
	int x;
	int y;

	Random rand = new Random();
	float float_random;

	public UFO(int id, Point location) {
		super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("ufo-sheet.png"), 24, 24), "STAND_LEFT");

	}

	public void update(Player player) {
		move(1);
		super.update(player);

	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("STAND_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0)).withScale(3)
						.withBounds(7, 13, 11, 7).withImageEffect(ImageEffect.FLIP_HORIZONTAL).build() });
				put("STAND_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0)).withScale(3).withBounds(7, 13, 11, 7).build() });
				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3).withBounds(4, 5, 5, 10)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3).withBounds(4, 5, 5, 10)
										.build() });

				put("WALK_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(4, 5, 5, 10).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3)
								.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(4, 5, 5, 10).build() });
			}
		};

	}

	public void move(float speed) {
		// instance of random class
		moveRHit(speed);
		
			
			
		
		
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
	}
}