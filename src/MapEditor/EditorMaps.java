package MapEditor;

import Level.Map;
import Maps.FinalPuzzleMap;
import Maps.PuzzleFourMap;
import Maps.PuzzleMap1;
import Maps.PuzzleThreeMap;
import Maps.PuzzleTwoMap;
import Maps.TestMap;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("PuzzleOneScreen");
            add("PuzzleTwoScreen");
            add("PuzzleThreeScreen");
            add("PuzzleFourScreen");
            add("FinalPuzzleScreen");

        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap(null, null);
            case "TitleScreen":
                return new TitleScreenMap(null, null);
            case "PuzzleOneScreen":
                return new PuzzleMap1(null, null);
            case "PuzzleTwoScreen":
                return new PuzzleTwoMap(null, null);
            case "PuzzleThreeScreen":
                return new PuzzleThreeMap(null, null);
            case "PuzzleFourScreen":
                return new PuzzleFourMap(null, null);
            case "FinalPuzzleScreen":
                return new FinalPuzzleMap(null, null);
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
