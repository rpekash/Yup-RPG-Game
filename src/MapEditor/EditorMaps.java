package MapEditor;

import Level.Map;
import Maps.PuzzleTwoMap;
import Maps.TestMap;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("PuzzleTwoScreen");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "PuzzleTwoScreen":
                return new PuzzleTwoMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
