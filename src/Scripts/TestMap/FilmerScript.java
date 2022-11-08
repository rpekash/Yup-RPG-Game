package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;
import Screens.PuzzleOneScreen;
import Utils.Direction;

// script for talking to OJ npc
public class FilmerScript extends Script<NPC> {

	// protected ScreenCoordinator screenCoordinator;
	@Override
	protected void setup() {

		lockPlayer();

		if (!isFlagSet("hasTalkedToFilmer")) {
			showTextbox();
			addTextToTextboxQueue("hey, we are trying to capture a picture of the UFO.");
			addTextToTextboxQueue("try to escape it so we can get one!");
			addTextToTextboxQueue("Talk to OJ if you need some help");
			entity.walk(Direction.RIGHT, 0);
			

		}

		else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToCowboy")) {
			addTextToTextboxQueue("try talking to the guy with a cowboy hat, he might help");
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
