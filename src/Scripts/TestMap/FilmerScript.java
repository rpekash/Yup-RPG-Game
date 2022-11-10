package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleFourScreen;
import Screens.PuzzleOneScreen;
import Screens.PuzzleThreeScreen;
import Screens.PuzzleTwoScreen;
import Utils.Direction;

// script for talking to OJ npc
public class FilmerScript extends Script<NPC> {

	// protected ScreenCoordinator screenCoordinator;
	@Override
	protected void setup() {

		lockPlayer();

		if (!isFlagSet("hasTalkedToFilmer")) {
			showTextbox();
			addTextToTextboxQueue("Hey, we are trying to capture a picture of the UFO.");
			addTextToTextboxQueue("Try to escape it so we can get one!");
			addTextToTextboxQueue("Talk to OJ if you need some help");
			entity.walk(Direction.RIGHT, 0);

		}

		else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToEm")) {
			addTextToTextboxQueue("Try finding the girl in the green shirt, she might help");
		}
		
		if (PuzzleTwoScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("I really thought you were gone for good\nin that maze, but you figured it out");
			addTextToTextboxQueue("Go find more portals so i can get a picture of the ufo.");
			
		}
		if (PuzzleThreeScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("That game must have been hard you look tired");
			addTextToTextboxQueue("There are still more protals!\ntry and find another");
		}
		
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}
		
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}
		
		

		// entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		setFlag("hasTalkedToFilmer");
		entity.stand(Direction.RIGHT);
		unlockPlayer();
		hideTextbox();
	}

	@Override
	public ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {

			return ScriptState.RUNNING;

		}

		end();

		return ScriptState.COMPLETED;
	}

}
