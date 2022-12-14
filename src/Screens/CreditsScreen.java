package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont createdByLabels;
    protected SpriteFont createdByLabelss;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap(null, screenCoordinator);
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 40, 60, "Times New Roman", 30, Color.black);
        createdByLabel = new SpriteFont("Original game Created by Alex Thimineur", 130, 140, "Times New Roman", 20, Color.black);
        createdByLabels = new SpriteFont("Created by Mia, Kash, Dylan", 130, 240, "Times New Roman", 20, Color.black);
        createdByLabelss = new SpriteFont("Game based off of the move NOPE", 130, 340, "Times New Roman", 20, Color.black);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 40, 530, "Times New Roman", 30, Color.black);
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
        createdByLabels.drawWithParsedNewLines(graphicsHandler);
        createdByLabelss.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
