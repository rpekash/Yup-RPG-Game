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
public class OJScript extends Script<NPC> {

	// protected ScreenCoordinator screenCoordinator;
	@Override
	protected void setup() {

		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("Hey,im Oj, your my horse Lucky. a UFO\nhas appeared and is trying to take you.");
		addTextToTextboxQueue("We dont know what it is or what it wants");
		addTextToTextboxQueue("Portals also showed up randomly,\nbut when dont know whats in them");
		addTextToTextboxQueue("You have to use the portals to escape The UFO!");
		entity.walk(Direction.RIGHT, 0);
		addTextToTextboxQueue("I think there is one over there.");
		if (isFlagSet("hasTalkedToFilmer")) {
			showTextbox();
			addTextToTextboxQueue(
					"Hey, to escape the UFO you have to win\neach game in the portals, there are 5 portals.");
		}
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("There is one final game you have to complete to escape.");
			addTextToTextboxQueue("Try going 'over yonder'");

		}
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}
		
		if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}
		
		if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}
		if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 3 more portals to find! try talking to the guy with the camera for help.");
			

		}

		// entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		setFlag("hasTalkedToOJ");
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
