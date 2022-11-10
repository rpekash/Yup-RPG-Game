package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import Screens.PuzzleFourScreen;
import Screens.PuzzleOneScreen;
import Screens.PuzzleThreeScreen;
import Screens.PuzzleTwoScreen;
import Utils.Direction;
import Utils.Point;

// script for talking to dino npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class CowboyScript extends Script<NPC> {

	private int sequence = 0;
	private int amountMoved = 0;

	@Override
	protected void setup() {
		lockPlayer();

		if (!isFlagSet("hasTalkedToCowboy")) {
			showTextbox();
			entity.walk(Direction.LEFT, amountMoved);
			addTextToTextboxQueue("Hi there.");
			addTextToTextboxQueue("What if I told you, in about an hour you'll leave here\n different"
					+ "ly? see, every Friday for the last six months.");
			
			addTextToTextboxQueue(" My family and I have borne witness to an absolutely\nspectacle one that you'll be seeing here today.");
			addTextToTextboxQueue("So let me take you back to that first night. Right\nhere in this exact spot,"
					+ " id come over to wrangle a");
			
			addTextToTextboxQueue("chestnut horse named trigger.");
			addTextToTextboxQueue("Now, I could barely see my hand in front of my face for\nthe fog,but I swear on my wife's and children's");
			addTextToTextboxQueue("lives that at 6:13 pm");
			addTextToTextboxQueue("I see … a flying saucer descend through the mist.\nOld trigger took off straight into the gulch.");
			addTextToTextboxQueue("and, well … it's like he was going home. Now just to be\nclear what we saw was a flying saucer");
			addTextToTextboxQueue("no doubt about that.");
			addTextToTextboxQueue("slightly flatter in the front, with a circular hole\nin the bottom about two school bus lengths wide.");
			addTextToTextboxQueue("I kid you not we are being surveilled by\nan alien species I call “the Viewers”");
			addTextToTextboxQueue("and though they have yet to emerge from\ntheir ship, i believe they trust me");
			addTextToTextboxQueue("if they didn't I dont believe we would be here right now.");
			addTextToTextboxQueue("Have you seen it?");
			
		}
		if (isFlagSet("hasTalkedToEm")) {
			showTextbox();
			//entity.walk(Direction.LEFT, amountMoved);
			//addTextToTextboxQueue("Hi there.");
			addTextToTextboxQueue("these portals are all over the place");
			addTextToTextboxQueue("just press the space bar to enter one");
			addTextToTextboxQueue("can you find one?");

		}

		else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToCowboy")) {
			showTextbox();
			addTextToTextboxQueue("I think there are some more portals try looking over there");
		}
		if (PuzzleOneScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("Hey, you completed a portal.");
			addTextToTextboxQueue("You almost ran out of time there");
			addTextToTextboxQueue("There are still more protals!\ntry and find another");
		}
		if (PuzzleThreeScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("Hey, you made it out. the last guy that tried didn't make it.");
			addTextToTextboxQueue("I wonder what happends when time runs out,\nit kinda reminds me of when");
			addTextToTextboxQueue("I was a kid on the show Gordies Home, and the\nmonkey on the show ... anyways long story maybe ill tell you sometime");
			addTextToTextboxQueue("There are still more protals!\ntry and find another");
		}
		
		if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
		
		else if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
		
		else if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
		else if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
		
		else if (PuzzleOneScreen.getCompleted() == true && PuzzleTwoScreen.getCompleted() == false
				&& PuzzleThreeScreen.getCompleted() == false && PuzzleFourScreen.getCompleted() == true) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
		
		else if (PuzzleOneScreen.getCompleted() == false && PuzzleTwoScreen.getCompleted() == true
				&& PuzzleThreeScreen.getCompleted() == true && PuzzleFourScreen.getCompleted() == false) {
			showTextbox();
			addTextToTextboxQueue("you have 2 more portals to find! try talking to the guy with the cowboy hat for help.");
			

		}
	}

	@Override
	protected void cleanup() {
		setFlag("hasTalkedToCowboy");
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
