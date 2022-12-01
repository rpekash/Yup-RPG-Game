package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class HowToPlayScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont one;
    protected SpriteFont two;
    protected SpriteFont returnInstructionsLabel;

    public HowToPlayScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap(null, screenCoordinator);
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("How To Play:", 40, 60, "Times New Roman", 30, Color.WHITE);
        creditsLabel.setOutlineColor(Color.black);
        creditsLabel.setOutlineThickness(3);
        createdByLabel = new SpriteFont("space key: interact with npcs or items", 45, 110, "Times New Roman", 30, Color.WHITE);
        createdByLabel.setOutlineColor(Color.black);
        createdByLabel.setOutlineThickness(3);
        one = new SpriteFont("movement: use the arrow keys", 45, 180, "Times New Roman", 30, Color.WHITE);
        one.setOutlineColor(Color.black);
        one.setOutlineThickness(3);
        
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 40, 530, "Times New Roman", 30, Color.white);
        returnInstructionsLabel.setOutlineColor(Color.black);
        returnInstructionsLabel.setOutlineThickness(3);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.drawWithParsedNewLines(graphicsHandler);
        one.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}

