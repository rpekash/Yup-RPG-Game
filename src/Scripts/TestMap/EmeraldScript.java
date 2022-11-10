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
public class EmeraldScript extends Script<NPC> {

	// protected ScreenCoordinator screenCoordinator;
	@Override
	protected void setup() {

		lockPlayer();

		if (isFlagSet("hasTalkedToOJ")) {
			showTextbox();
			addTextToTextboxQueue("hey, im emerald. OJ is my brother,\nand this is our horse ranch");
			addTextToTextboxQueue("we found out that some portals\ndo damage, and some are timed. so be careful.");

			entity.walk(Direction.RIGHT, 0);
			addTextToTextboxQueue("try going into the portal over there.");

		}
		if (!isFlagSet("hasTalkedToCowboy")) {
			showTextbox();
			addTextToTextboxQueue(
					"try talking to the guy with the cowboy had\nif your having trouble opening the portals");
			addTextToTextboxQueue("I dont know why but he knows alot about the strange stuff going on.");
		}

		else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToCowboy")) {
			addTextToTextboxQueue("try talking to the guy with a cowboy hat, he might help");
		}
		if (PuzzleTwoScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("That maze game did some damage!");
			addTextToTextboxQueue(
					"steping on the traps does damage, and walking\ninfront of an arrow trap will shot you");
			addTextToTextboxQueue("there are still more protals!\ntry and find another");
		}
		if (PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("That game must have been hard you look tired");
			addTextToTextboxQueue("there are still more protals!\ntry and find another");
		}
		
		if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 1 more portal to find! try talking to OJ for help.");
			

		}
		
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 1 more portal to find! try talking to OJ for help.");
			

		}
		
		
		

		// entity.facePlayer(player);

	}

	@Override
	protected void cleanup() {
		setFlag("hasTalkedToEm");
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
