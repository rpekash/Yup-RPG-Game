package MapEditor;

import Level.Map;
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
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "PuzzleOneScreen":
                return new PuzzleMap1();
            case "PuzzleTwoScreen":
                return new PuzzleTwoMap();
            case "PuzzleThreeScreen":
                return new PuzzleThreeMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
