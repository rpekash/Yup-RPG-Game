package Scripts.TestMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
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

		if (isFlagSet("hasTalkedToEm")) {
			showTextbox();
			entity.walk(Direction.LEFT, amountMoved);
			addTextToTextboxQueue("Hi there.");
			addTextToTextboxQueue("these portals are all over the place");
			addTextToTextboxQueue("just press the space bar to enter one");
			addTextToTextboxQueue("can you find one?");

		}

		else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToCowboy")) {
			if (sequence == 0) {
				showTextbox();
				addTextToTextboxQueue("I think there are some more portals try looking over there");
			} else if (sequence == 1) {

			} else if (sequence == 2) {
				entity.facePlayer(player);
				showTextbox();
				addTextToTextboxQueue("Oh, you're still here...");

			} else if (sequence == 3) {
				entity.stand(Direction.RIGHT);
				amountMoved = 0;
			} else if (sequence == 4) {
				amountMoved = 0;
			} else if (sequence == 5) {
				entity.stand(Direction.LEFT);

			}
		}
	}

	@Override
	protected void cleanup() {
		if (isFlagSet("hasTalkedToOJ")) {
			unlockPlayer();
			hideTextbox();
			entity.stand(Direction.LEFT);
		} else if (isFlagSet("hasTalkedToOJ") && !isFlagSet("hasTalkedToCowboy")) {
			if (sequence == 0) {
				hideTextbox();
				sequence++;
			} else if (sequence == 1) {
				sequence++;
			} else if (sequence == 2) {
				hideTextbox();
				sequence++;
			} else if (sequence == 3) {
				sequence++;
			} else if (sequence == 4) {
				sequence++;
			} else if (sequence == 5) {
				sequence++;

				setFlag("hasTalkedToCowboy");
				unlockPlayer();
			}
		}
	}

	@Override
	public ScriptState execute() {
		if (!isFlagSet("hasTalkedToOJ")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
			return ScriptState.COMPLETED;
		} else if (!isFlagSet("hasTalkedToOJ")) {
			// talks
			if (sequence == 0) {
				start();
				if (isTextboxQueueEmpty()) {
					end();
				}
			}
			// pauses
			else if (sequence == 1) {
				start();
				entity.stand(Direction.LEFT);

				if (isWaitTimeUp()) {
					end();
				}
			}
			// talks more
			else if (sequence == 2) {
				start();
				if (isTextboxQueueEmpty()) {
					end();
				}
			}
			// walk downwards
			else if (sequence == 3) {
				start();
				entity.walk(Direction.DOWN, 2);
				amountMoved += 2;
				if (amountMoved == 36) {
					end();
				}
			}
			// walk right
			else if (sequence == 4) {
				start();
				entity.walk(Direction.RIGHT, 2);
				amountMoved += 2;
				if (amountMoved == 196) {
					end();
				}
			}
			// walk up
			else if (sequence == 5) {
				start();
				entity.walk(Direction.UP, 2);
				amountMoved += 2;
				if (amountMoved == 50) {
					end();
				}
			}
			return ScriptState.RUNNING;
		}
		return ScriptState.COMPLETED;
	}
}
