package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

import java.util.HashMap;

// This class is for the OJ NPC
public class OJ extends NPC {

    public OJ(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("OJ.png"), 24, 24), "STAND_LEFT");
    }

    public void update(Player player) {
        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build()
           });
            put("WALK_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 200)
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 200)
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build()
            });

            put("WALK_RIGHT", new Frame[]{
            		new FrameBuilder(spriteSheet.getSprite(1, 0), 500)
                       .withScale(3)
                       .withBounds(4, 5, 5, 10)
                       .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                       .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 500)
                       .withScale(3)
                       .withBounds(4, 5, 5, 10)
                       .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                       .build()
       });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
