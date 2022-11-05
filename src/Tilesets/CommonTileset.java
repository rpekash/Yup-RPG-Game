package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("CommonTileset3.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame);

        mapTiles.add(grassTile);

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder signTile = new MapTileBuilder(signFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(signTile);

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);

        mapTiles.add(sandTile);

        // rock
        Frame rockFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder rockTile = new MapTileBuilder(rockFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rockTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftEndBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightEndBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightEndBranchTile);
        
        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTopLeavesFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(treeTopLeavesTile);
        
        // yellow flower
        Frame[] yellowFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 500)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 3), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 2), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 500)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

        mapTiles.add(yellowFlowerTile);

        // purple flower
        Frame[] purpleFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 2), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 2), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 500)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

        mapTiles.add(purpleFlowerTile);

        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleBranchFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(middleBranchTile);

        // tree trunk bottom
        Frame treeTrunkBottomFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkBottomTile = new MapTileBuilder(treeTrunkBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkBottomTile);

        // mushrooms
        Frame mushroomFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(mushroomTile);


        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(greyRockTile);

        // bush
        Frame bushFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bushTile = new MapTileBuilder(bushFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bushTile);

        // house body
        Frame houseBodyFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseBodyTile = new MapTileBuilder(houseBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(houseBodyTile);

        // house roof body
        Frame houseRoofBodyFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseRoofBodyTile = new MapTileBuilder(grassFrame)
                .withTopLayer(houseRoofBodyFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(houseRoofBodyTile);

        // left house roof
        Frame leftHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftHouseRoofTile);

        // right house roof
        Frame rightHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightHouseRoofTile);

        // left window
        Frame leftWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftWindowTile = new MapTileBuilder(leftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftWindowTile);

        // right window
        Frame rightWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightWindowTile = new MapTileBuilder(rightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightWindowTile);

        // door
        Frame doorFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(doorTile);
        
        //fence 
        Frame fenceFrame = new FrameBuilder(getSubImage(6, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder fenceTile = new MapTileBuilder(fenceFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fenceTile);
        
        Frame fence2Frame = new FrameBuilder(getSubImage(6, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence2Tile = new MapTileBuilder(fence2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence2Tile);
        
        Frame fence3Frame = new FrameBuilder(getSubImage(6, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence3Tile = new MapTileBuilder(fence3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence3Tile);
        
        Frame fence4Frame = new FrameBuilder(getSubImage(6, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence4Tile = new MapTileBuilder(fence4Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence4Tile);
        
        Frame fence5Frame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence5Tile = new MapTileBuilder(fence5Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence5Tile);
        
        Frame fence6Frame = new FrameBuilder(getSubImage(7, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence6Tile = new MapTileBuilder(fence6Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence6Tile);
        
        Frame fence7Frame = new FrameBuilder(getSubImage(7, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence7Tile = new MapTileBuilder(fence7Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence7Tile);
        
        Frame fence8Frame = new FrameBuilder(getSubImage(7, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence8Tile = new MapTileBuilder(fence8Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence8Tile);
        
        Frame fence9Frame = new FrameBuilder(getSubImage(7, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence9Tile = new MapTileBuilder(fence9Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence9Tile);
        
        Frame fence10Frame = new FrameBuilder(getSubImage(7, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence10Tile = new MapTileBuilder(fence10Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence10Tile);
        
        Frame fence11Frame = new FrameBuilder(getSubImage(8, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder fence11Tile = new MapTileBuilder(fence11Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(fence11Tile);
        
        //sand
        Frame sand = new FrameBuilder(getSubImage(8, 1))
                .withScale(tileScale)
                .build();
        
        // blow up man
        Frame[] yBlowupFrames = new Frame[] {
            new FrameBuilder(getSubImage(9, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 4), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 0), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 1), 500)
                    .withScale(tileScale)
                    .build(),
            
            
        };

        MapTileBuilder yBlowupTile = new MapTileBuilder(yBlowupFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(yBlowupTile);
        
     // blow up man
        Frame[] bBlowupFrames = new Frame[] {
            new FrameBuilder(getSubImage(10, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(10, 4), 500)
                    .withScale(tileScale)
                    .build(),
            
            
        };

        MapTileBuilder bBlowupTile = new MapTileBuilder(bBlowupFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bBlowupTile);
        
        
     
        
       

        MapTileBuilder sandTile1 = new MapTileBuilder(sand)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandTile1);
        
        Frame sandPath1 = new FrameBuilder(getSubImage(8, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile1 = new MapTileBuilder(sandPath1)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile1);
        
        Frame sandPath2 = new FrameBuilder(getSubImage(8, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile2 = new MapTileBuilder(sandPath2)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile2);
        
        Frame sandPath3 = new FrameBuilder(getSubImage(8, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile3 = new MapTileBuilder(sandPath3)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile3);
        
        Frame sandPath4 = new FrameBuilder(getSubImage(9, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile4 = new MapTileBuilder(sandPath4)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile4);
        
        Frame sandPath5 = new FrameBuilder(getSubImage(9, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile5 = new MapTileBuilder(sandPath5)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile5);
        
        Frame sandPath6 = new FrameBuilder(getSubImage(9, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandPathTile6 = new MapTileBuilder(sandPath6)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(sandPathTile6);
        
        
     // spikeTrap
        Frame spikeFrame = new FrameBuilder(getSubImage(11, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder spikeTile = new MapTileBuilder(spikeFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(spikeTile);
        
        
     // arrowTrap
        Frame arrowTrapFrame = new FrameBuilder(getSubImage(11, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder arrowTrapTile = new MapTileBuilder(arrowTrapFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(arrowTrapTile);
        
     // shoot arrowTrap
        Frame arrowSTrapFrame = new FrameBuilder(getSubImage(11, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder arrowSTrapTile = new MapTileBuilder(arrowSTrapFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(arrowSTrapTile);
        
     // arrow animation
        Frame[] arrowFrames = new Frame[] {
                new FrameBuilder(getSubImage(12, 0), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(12, 1), 500)
                        .withScale(tileScale)
                        .build(),
            };

            MapTileBuilder arrowTile = new MapTileBuilder(arrowFrames)
                    .withTileType(TileType.PASSABLE);

            mapTiles.add(arrowTile);
        
       
      //arena
            Frame boxFrame = new FrameBuilder(getSubImage(12, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder boxTile = new MapTileBuilder(boxFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(boxTile);
            Frame box1Frame = new FrameBuilder(getSubImage(12, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder box1Tile = new MapTileBuilder(box1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(box1Tile);
            
            Frame arenaFrame = new FrameBuilder(getSubImage(13, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arenaTile = new MapTileBuilder(arenaFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arenaTile);
            
            Frame arena1Frame = new FrameBuilder(getSubImage(13, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena1Tile = new MapTileBuilder(arena1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena1Tile);
            
            Frame arena2Frame = new FrameBuilder(getSubImage(13, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena2Tile = new MapTileBuilder(arena2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena2Tile);
            
            Frame arena3Frame = new FrameBuilder(getSubImage(13, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena3Tile = new MapTileBuilder(arena3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena3Tile);
            
            Frame arena4Frame = new FrameBuilder(getSubImage(13, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena4Tile = new MapTileBuilder(arena4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena4Tile);
            
            Frame arena5Frame = new FrameBuilder(getSubImage(14, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena5Tile = new MapTileBuilder(arena5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena5Tile);
            
            Frame arena6Frame = new FrameBuilder(getSubImage(14, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena6Tile = new MapTileBuilder(arena6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena6Tile);
            
            Frame arena7Frame = new FrameBuilder(getSubImage(14, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena7Tile = new MapTileBuilder(arena7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena7Tile);
            
            Frame arena8Frame = new FrameBuilder(getSubImage(14, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena8Tile = new MapTileBuilder(arena8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena8Tile);
            
            Frame arena9Frame = new FrameBuilder(getSubImage(14, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena9Tile = new MapTileBuilder(arena9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena9Tile);
            
            Frame arena10Frame = new FrameBuilder(getSubImage(15, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena10Tile = new MapTileBuilder(arena10Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena10Tile);
            
            Frame arena11Frame = new FrameBuilder(getSubImage(15, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena11Tile = new MapTileBuilder(arena11Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena11Tile);
            
            Frame arena12Frame = new FrameBuilder(getSubImage(15, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena12Tile = new MapTileBuilder(arena12Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena12Tile);
            
            Frame arena13Frame = new FrameBuilder(getSubImage(15, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena13Tile = new MapTileBuilder(arena13Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena13Tile);
            
            Frame arena14Frame = new FrameBuilder(getSubImage(15, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena14Tile = new MapTileBuilder(arena14Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena14Tile);
            
            Frame arena15Frame = new FrameBuilder(getSubImage(16, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena15Tile = new MapTileBuilder(arena15Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena15Tile);
            
            Frame arena16Frame = new FrameBuilder(getSubImage(16, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena16Tile = new MapTileBuilder(arena16Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena16Tile);
            
            Frame arena17Frame = new FrameBuilder(getSubImage(16, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena17Tile = new MapTileBuilder(arena17Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena17Tile);
            
            Frame arena18Frame = new FrameBuilder(getSubImage(16, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena18Tile = new MapTileBuilder(arena18Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena18Tile);
            
            Frame arena19Frame = new FrameBuilder(getSubImage(16, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena19Tile = new MapTileBuilder(arena19Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena19Tile);
            
            Frame arena20Frame = new FrameBuilder(getSubImage(17, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena20Tile = new MapTileBuilder(arena20Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena20Tile);
            
            Frame arena21Frame = new FrameBuilder(getSubImage(17, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena21Tile = new MapTileBuilder(arena21Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena21Tile);
            
            Frame arena22Frame = new FrameBuilder(getSubImage(17, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena22Tile = new MapTileBuilder(arena22Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena22Tile);
            
            Frame arena23Frame = new FrameBuilder(getSubImage(17, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena23Tile = new MapTileBuilder(arena23Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena23Tile);
            
            Frame arena24Frame = new FrameBuilder(getSubImage(17, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena24Tile = new MapTileBuilder(arena24Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena24Tile);
            
            Frame arena25Frame = new FrameBuilder(getSubImage(18, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena25Tile = new MapTileBuilder(arena25Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena25Tile);
            
            Frame arena26Frame = new FrameBuilder(getSubImage(18, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena26Tile = new MapTileBuilder(arena26Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena26Tile);
            
            Frame arena27Frame = new FrameBuilder(getSubImage(18, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena27Tile = new MapTileBuilder(arena27Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena27Tile);
            
            Frame arena28Frame = new FrameBuilder(getSubImage(18, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena28Tile = new MapTileBuilder(arena28Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena28Tile);
            
            Frame arena29Frame = new FrameBuilder(getSubImage(18, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena29Tile = new MapTileBuilder(arena29Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena29Tile);
            
            Frame arena30Frame = new FrameBuilder(getSubImage(19, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena30Tile = new MapTileBuilder(arena30Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena30Tile);
            
            Frame arena31Frame = new FrameBuilder(getSubImage(19, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena31Tile = new MapTileBuilder(arena31Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena31Tile);
            
            Frame arena32Frame = new FrameBuilder(getSubImage(19, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena32Tile = new MapTileBuilder(arena32Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena32Tile);
            
            Frame arena33Frame = new FrameBuilder(getSubImage(19, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena33Tile = new MapTileBuilder(arena33Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena33Tile);
            
            Frame arena34Frame = new FrameBuilder(getSubImage(19, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena34Tile = new MapTileBuilder(arena34Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena34Tile);
            
            Frame arena35Frame = new FrameBuilder(getSubImage(20, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena35Tile = new MapTileBuilder(arena35Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena35Tile);
            
            Frame arena36Frame = new FrameBuilder(getSubImage(20, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena36Tile = new MapTileBuilder(arena36Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena36Tile);
            
            Frame arena37Frame = new FrameBuilder(getSubImage(20, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena37Tile = new MapTileBuilder(arena37Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena37Tile);
            
            Frame arena38Frame = new FrameBuilder(getSubImage(20, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena38Tile = new MapTileBuilder(arena38Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena38Tile);
            
            Frame arena39Frame = new FrameBuilder(getSubImage(20, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena39Tile = new MapTileBuilder(arena39Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena39Tile);
            
            Frame arena40Frame = new FrameBuilder(getSubImage(21, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena40Tile = new MapTileBuilder(arena40Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena40Tile);
            
            Frame arena41Frame = new FrameBuilder(getSubImage(21, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena41Tile = new MapTileBuilder(arena41Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena41Tile);
            
            Frame arena42Frame = new FrameBuilder(getSubImage(21, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena42Tile = new MapTileBuilder(arena42Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena42Tile);
            
            Frame arena43Frame = new FrameBuilder(getSubImage(21, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena43Tile = new MapTileBuilder(arena43Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena43Tile);
            
            Frame arena44Frame = new FrameBuilder(getSubImage(21, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena44Tile = new MapTileBuilder(arena44Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena44Tile);
            
            Frame arena45Frame = new FrameBuilder(getSubImage(22, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena45Tile = new MapTileBuilder(arena45Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena45Tile);
            
            Frame arena46Frame = new FrameBuilder(getSubImage(22, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena46Tile = new MapTileBuilder(arena46Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena46Tile);
            
            Frame arena47Frame = new FrameBuilder(getSubImage(22, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena47Tile = new MapTileBuilder(arena47Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena47Tile);
            
            Frame arena48Frame = new FrameBuilder(getSubImage(22, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena48Tile = new MapTileBuilder(arena48Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena48Tile);
            
            Frame arena49Frame = new FrameBuilder(getSubImage(22, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena49Tile = new MapTileBuilder(arena49Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena49Tile);
            
            Frame arena50Frame = new FrameBuilder(getSubImage(23, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena50Tile = new MapTileBuilder(arena50Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena50Tile);
            
            Frame arena51Frame = new FrameBuilder(getSubImage(23, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena51Tile = new MapTileBuilder(arena51Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena51Tile);
            
            Frame arena52Frame = new FrameBuilder(getSubImage(23, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena52Tile = new MapTileBuilder(arena52Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena12Tile);
            
            Frame arena53Frame = new FrameBuilder(getSubImage(23, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena53Tile = new MapTileBuilder(arena53Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena53Tile);
            
            Frame arena54Frame = new FrameBuilder(getSubImage(23, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena54Tile = new MapTileBuilder(arena54Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena54Tile);
            
            Frame arena55Frame = new FrameBuilder(getSubImage(24, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena55Tile = new MapTileBuilder(arena55Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena55Tile);
            
            Frame arena56Frame = new FrameBuilder(getSubImage(24, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena56Tile = new MapTileBuilder(arena56Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena56Tile);
            
            
            
            Frame arena58Frame = new FrameBuilder(getSubImage(24, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena58Tile = new MapTileBuilder(arena58Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena58Tile);
            
            Frame arena59Frame = new FrameBuilder(getSubImage(24, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena59Tile = new MapTileBuilder(arena59Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena59Tile);
            
            Frame arena60Frame = new FrameBuilder(getSubImage(25, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena60Tile = new MapTileBuilder(arena60Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena60Tile);
            
            Frame arena61Frame = new FrameBuilder(getSubImage(25, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena61Tile = new MapTileBuilder(arena61Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena61Tile);
            
            Frame arena62Frame = new FrameBuilder(getSubImage(25, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena62Tile = new MapTileBuilder(arena62Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(arena62Tile);
            
            Frame arena63Frame = new FrameBuilder(getSubImage(25, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder arena63Tile = new MapTileBuilder(arena63Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(arena63Tile);
            
           
            
     // top water
        Frame[] topWaterFrames = new Frame[] {
            new FrameBuilder(getSubImage(5, 0), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 0), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 4), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 500)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topWaterTile);
        
        return mapTiles;
    }
}
