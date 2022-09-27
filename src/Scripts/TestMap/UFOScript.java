package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to OJ npc
public class UFOScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue( "I'm coming to get you.");
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
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
