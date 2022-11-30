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

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame)
        		.withTileType(TileType.NOT_PASSABLE);

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

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame)
        		.withTileType(TileType.NOT_PASSABLE);

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

        MapTileBuilder treeTrunkTile = new MapTileBuilder(treeTrunkFrame)
        		.withTileType(TileType.NOT_PASSABLE);
                

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(treeTopLeavesFrame)
        		.withTileType(TileType.NOT_PASSABLE);
                

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
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(boxTile);
            Frame box1Frame = new FrameBuilder(getSubImage(12, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder box1Tile = new MapTileBuilder(box1Frame)
                    .withTileType(TileType.PASSABLE);
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
            mapTiles.add(arena52Tile);
            
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
            
           
            Frame wallFrame = new FrameBuilder(getSubImage(25, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder wallTile = new MapTileBuilder(wallFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(wallTile);
            
            Frame wall1Frame = new FrameBuilder(getSubImage(26, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder wall1Tile = new MapTileBuilder(wall1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(wall1Tile);
            
            Frame wall2Frame = new FrameBuilder(getSubImage(26, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder wall2Tile = new MapTileBuilder(wall2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(wall2Tile);
            
            Frame wall3Frame = new FrameBuilder(getSubImage(26, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder wall3Tile = new MapTileBuilder(wall3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(wall3Tile);
            
            Frame wall4Frame = new FrameBuilder(getSubImage(26, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder wall4Tile = new MapTileBuilder(wall4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(wall4Tile);  
            
            //house
            Frame house1Frame = new FrameBuilder(getSubImage(27, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house1Tile = new MapTileBuilder(house1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house1Tile);
            
            Frame house2Frame = new FrameBuilder(getSubImage(27, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house2Tile = new MapTileBuilder(house2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house2Tile);
            
            Frame house3Frame = new FrameBuilder(getSubImage(27, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house3Tile = new MapTileBuilder(house3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house3Tile);
            
            Frame house4Frame = new FrameBuilder(getSubImage(27, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house4Tile = new MapTileBuilder(house4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house4Tile); 
            
            Frame house5Frame = new FrameBuilder(getSubImage(27, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house5Tile = new MapTileBuilder(house5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house5Tile); 
            
            Frame house6Frame = new FrameBuilder(getSubImage(28, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house6Tile = new MapTileBuilder(house6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house6Tile);
            
            Frame house7Frame = new FrameBuilder(getSubImage(28, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house7Tile = new MapTileBuilder(house7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house7Tile);
            
            Frame house8Frame = new FrameBuilder(getSubImage(28, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house8Tile = new MapTileBuilder(house8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house8Tile);
            
            Frame house9Frame = new FrameBuilder(getSubImage(28, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house9Tile = new MapTileBuilder(house9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house9Tile); 
            
            Frame house10Frame = new FrameBuilder(getSubImage(28, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house10Tile = new MapTileBuilder(house10Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house10Tile); 
            
            Frame house11Frame = new FrameBuilder(getSubImage(29, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house11Tile = new MapTileBuilder(house11Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house11Tile);
            
            Frame house12Frame = new FrameBuilder(getSubImage(29, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house12Tile = new MapTileBuilder(house12Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house12Tile);
            
            Frame house13Frame = new FrameBuilder(getSubImage(29, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house13Tile = new MapTileBuilder(house13Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house13Tile);
            
            Frame house14Frame = new FrameBuilder(getSubImage(29, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house14Tile = new MapTileBuilder(house14Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house14Tile); 
            
            Frame house15Frame = new FrameBuilder(getSubImage(29, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house15Tile = new MapTileBuilder(house15Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house15Tile); 
            
            Frame house16Frame = new FrameBuilder(getSubImage(30, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house16Tile = new MapTileBuilder(house16Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house16Tile);
            
            Frame house17Frame = new FrameBuilder(getSubImage(30, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house17Tile = new MapTileBuilder(house17Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house17Tile);
            
            Frame house18Frame = new FrameBuilder(getSubImage(30, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house18Tile = new MapTileBuilder(house18Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house18Tile);
            
            Frame house19Frame = new FrameBuilder(getSubImage(30, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house19Tile = new MapTileBuilder(house19Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house19Tile); 
            
            Frame house20Frame = new FrameBuilder(getSubImage(30, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder house20Tile = new MapTileBuilder(house20Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(house20Tile); 
            
     // bank
            Frame bankFrame = new FrameBuilder(getSubImage(31, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bankTile = new MapTileBuilder(bankFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bankTile);
            
            Frame bank1Frame = new FrameBuilder(getSubImage(31, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank1Tile = new MapTileBuilder(bank1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank1Tile);
            
            Frame bank2Frame = new FrameBuilder(getSubImage(31, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank2Tile = new MapTileBuilder(bank2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank2Tile);
            
            Frame bank3Frame = new FrameBuilder(getSubImage(32, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank3Tile = new MapTileBuilder(bank3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank3Tile);
            
            Frame bank4Frame = new FrameBuilder(getSubImage(32, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank4Tile = new MapTileBuilder(bank4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank4Tile);
            
            Frame bank5Frame = new FrameBuilder(getSubImage(32, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank5Tile = new MapTileBuilder(bank5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank5Tile);
            
            Frame bank6Frame = new FrameBuilder(getSubImage(33, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank6Tile = new MapTileBuilder(bank6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank6Tile);
            
            Frame bank7Frame = new FrameBuilder(getSubImage(33, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank7Tile = new MapTileBuilder(bank7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank7Tile);
            
            Frame bank8Frame = new FrameBuilder(getSubImage(33, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bank8Tile = new MapTileBuilder(bank8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bank8Tile);
            
      //office
            Frame offFrame = new FrameBuilder(getSubImage(31, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder offTile = new MapTileBuilder(offFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(offTile);
            
            Frame off1Frame = new FrameBuilder(getSubImage(31, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off1Tile = new MapTileBuilder(off1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off1Tile);
            
            Frame off2Frame = new FrameBuilder(getSubImage(32, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off2Tile = new MapTileBuilder(off2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off2Tile);
            
            Frame off3Frame = new FrameBuilder(getSubImage(32, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off3Tile = new MapTileBuilder(off3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off3Tile);
            
            Frame off4Frame = new FrameBuilder(getSubImage(33, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off4Tile = new MapTileBuilder(off4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off4Tile);
            
            Frame off5Frame = new FrameBuilder(getSubImage(33, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off5Tile = new MapTileBuilder(off5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off5Tile);
            
            Frame off6Frame = new FrameBuilder(getSubImage(34, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off6Tile = new MapTileBuilder(off6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off6Tile);
            
            Frame off7Frame = new FrameBuilder(getSubImage(34, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off7Tile = new MapTileBuilder(off7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off7Tile);
            
            Frame off8Frame = new FrameBuilder(getSubImage(34, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off8Tile = new MapTileBuilder(off8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off8Tile);
            
            Frame off9Frame = new FrameBuilder(getSubImage(34, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder off9Tile = new MapTileBuilder(off9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(off9Tile);
            
      //barber 
            Frame barbFrame = new FrameBuilder(getSubImage(34, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder barbTile = new MapTileBuilder(barbFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(barbTile);
            
            Frame barb1Frame = new FrameBuilder(getSubImage(38, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder barb1Tile = new MapTileBuilder(barb1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(barb1Tile);
            
            Frame barb2Frame = new FrameBuilder(getSubImage(38, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder barb2Tile = new MapTileBuilder(barb2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(barb2Tile);
            
            Frame barb3Frame = new FrameBuilder(getSubImage(38, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder barb3Tile = new MapTileBuilder(barb3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(barb3Tile);
            
      //candy
            Frame canFrame = new FrameBuilder(getSubImage(35, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder canTile = new MapTileBuilder(canFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(canTile);
            
            Frame can1Frame = new FrameBuilder(getSubImage(35, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can1Tile = new MapTileBuilder(can1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can1Tile);
            
            Frame can2Frame = new FrameBuilder(getSubImage(35, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can2Tile = new MapTileBuilder(can2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can2Tile);
            
            Frame can3Frame = new FrameBuilder(getSubImage(36, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can3Tile = new MapTileBuilder(can3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can3Tile);
            
            Frame can4Frame = new FrameBuilder(getSubImage(36, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can4Tile = new MapTileBuilder(can4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can4Tile);
            
            Frame can5Frame = new FrameBuilder(getSubImage(36, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can5Tile = new MapTileBuilder(can5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can5Tile);
            
            Frame can6Frame = new FrameBuilder(getSubImage(37, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can6Tile = new MapTileBuilder(can6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can6Tile);
            
            Frame can7Frame = new FrameBuilder(getSubImage(37, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can7Tile = new MapTileBuilder(can7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can7Tile);
            
            Frame can8Frame = new FrameBuilder(getSubImage(37, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder can8Tile = new MapTileBuilder(can8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(can8Tile);
     
     //jupes store
            
            Frame jupFrame = new FrameBuilder(getSubImage(35, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jupTile = new MapTileBuilder(jupFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jupTile);
            
            Frame jup1Frame = new FrameBuilder(getSubImage(35, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup1Tile = new MapTileBuilder(jup1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup1Tile);
            
            Frame jup2Frame = new FrameBuilder(getSubImage(36, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup2Tile = new MapTileBuilder(jup2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup2Tile);
            
            Frame jup3Frame = new FrameBuilder(getSubImage(36, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup3Tile = new MapTileBuilder(jup3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup3Tile);
            
            Frame jup4Frame = new FrameBuilder(getSubImage(37, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup4Tile = new MapTileBuilder(jup4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup4Tile);
            
            Frame jup5Frame = new FrameBuilder(getSubImage(37, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup5Tile = new MapTileBuilder(jup5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup5Tile);
            
            Frame jup6Frame = new FrameBuilder(getSubImage(38, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup6Tile = new MapTileBuilder(jup6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup6Tile);
            
            Frame jup7Frame = new FrameBuilder(getSubImage(38, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup7Tile = new MapTileBuilder(jup7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup7Tile);
            
            Frame jup8Frame = new FrameBuilder(getSubImage(39, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder jup8Tile = new MapTileBuilder(jup8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(jup8Tile);
            
     //salloon 
            Frame salFrame = new FrameBuilder(getSubImage(40, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder salTile = new MapTileBuilder(salFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(salTile);
            
            Frame sal1Frame = new FrameBuilder(getSubImage(40, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal1Tile = new MapTileBuilder(sal1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal1Tile);
            
            Frame sal2Frame = new FrameBuilder(getSubImage(40, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal2Tile = new MapTileBuilder(sal2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal2Tile);
            
            Frame sal3Frame = new FrameBuilder(getSubImage(40, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal3Tile = new MapTileBuilder(sal3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal3Tile);
            
            Frame sal4Frame = new FrameBuilder(getSubImage(41, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal4Tile = new MapTileBuilder(sal4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal4Tile);
            
            Frame sal5Frame = new FrameBuilder(getSubImage(41, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal5Tile = new MapTileBuilder(sal5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal5Tile);
            
            Frame sal6Frame = new FrameBuilder(getSubImage(41, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal6Tile = new MapTileBuilder(sal6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal6Tile);
            
            Frame sal7Frame = new FrameBuilder(getSubImage(41, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal7Tile = new MapTileBuilder(sal7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal7Tile);
            
            Frame sal8Frame = new FrameBuilder(getSubImage(42, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal8Tile = new MapTileBuilder(sal8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal8Tile);
            
            Frame sal9Frame = new FrameBuilder(getSubImage(42, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal9Tile = new MapTileBuilder(sal9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal9Tile);
            
            Frame sal10Frame = new FrameBuilder(getSubImage(42, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal10Tile = new MapTileBuilder(sal10Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal10Tile);
            
            Frame sal11Frame = new FrameBuilder(getSubImage(42, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sal11Tile = new MapTileBuilder(sal11Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(sal11Tile);
            
      //side building blue
            
            Frame rightbFrame = new FrameBuilder(getSubImage(43, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightbTile = new MapTileBuilder(rightbFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightbTile);
            
            Frame rightb1Frame = new FrameBuilder(getSubImage(43, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightb1Tile = new MapTileBuilder(rightb1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightb1Tile);
            
            Frame rightb2Frame = new FrameBuilder(getSubImage(43, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightb2Tile = new MapTileBuilder(rightb2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightb2Tile);
            
            Frame rightb3Frame = new FrameBuilder(getSubImage(43, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightb3Tile = new MapTileBuilder(rightb3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightb3Tile);
            
            Frame rightb4Frame = new FrameBuilder(getSubImage(43, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightb4Tile = new MapTileBuilder(rightb4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightb4Tile);
            
            Frame rightb5Frame = new FrameBuilder(getSubImage(44, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightb5Tile = new MapTileBuilder(rightb5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightb5Tile);
            
  //side building red
            
            Frame rightrFrame = new FrameBuilder(getSubImage(44, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightrTile = new MapTileBuilder(rightrFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightrTile);
            
            Frame rightr1Frame = new FrameBuilder(getSubImage(44, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightr1Tile = new MapTileBuilder(rightr1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightr1Tile);
            
            Frame rightr2Frame = new FrameBuilder(getSubImage(44, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightr2Tile = new MapTileBuilder(rightr2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightr2Tile);
            
            Frame rightr3Frame = new FrameBuilder(getSubImage(44, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightr3Tile = new MapTileBuilder(rightr3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightr3Tile);
            
            Frame rightr4Frame = new FrameBuilder(getSubImage(45, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightr4Tile = new MapTileBuilder(rightr4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightr4Tile);
            
            Frame rightr5Frame = new FrameBuilder(getSubImage(45, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightr5Tile = new MapTileBuilder(rightr5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightr5Tile);
            
            
 //side building green
            
            Frame rightgFrame = new FrameBuilder(getSubImage(45, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightgTile = new MapTileBuilder(rightgFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightgTile);
            
            Frame rightg1Frame = new FrameBuilder(getSubImage(45, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg1Tile = new MapTileBuilder(rightg1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg1Tile);
            
            Frame rightg2Frame = new FrameBuilder(getSubImage(45, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg2Tile = new MapTileBuilder(rightg2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg2Tile);
            
            Frame rightg3Frame = new FrameBuilder(getSubImage(46, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg3Tile = new MapTileBuilder(rightg3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg3Tile);
            
            Frame rightg4Frame = new FrameBuilder(getSubImage(46, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg4Tile = new MapTileBuilder(rightg4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg4Tile);
            
            Frame rightg5Frame = new FrameBuilder(getSubImage(46, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg5Tile = new MapTileBuilder(rightg5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg5Tile);
            
            Frame rightg6Frame = new FrameBuilder(getSubImage(46, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg6Tile = new MapTileBuilder(rightg6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg6Tile);
            
            Frame rightg7Frame = new FrameBuilder(getSubImage(46, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg7Tile = new MapTileBuilder(rightg7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg7Tile);
            
            Frame rightg8Frame = new FrameBuilder(getSubImage(47, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg8Tile = new MapTileBuilder(rightg8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg8Tile);
            
            Frame rightg9Frame = new FrameBuilder(getSubImage(47, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg9Tile = new MapTileBuilder(rightg9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg9Tile);
            
            Frame rightg10Frame = new FrameBuilder(getSubImage(47, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg10Tile = new MapTileBuilder(rightg10Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg10Tile);
            
            Frame rightg11Frame = new FrameBuilder(getSubImage(47, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg11Tile = new MapTileBuilder(rightg11Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg11Tile);
            
            Frame rightg12Frame = new FrameBuilder(getSubImage(47, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder rightg12Tile = new MapTileBuilder(rightg12Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(rightg12Tile);
            
            //side building green
            
            Frame leftgFrame = new FrameBuilder(getSubImage(0, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftgTile = new MapTileBuilder(leftgFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftgTile);
            
            Frame leftg1Frame = new FrameBuilder(getSubImage(1, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftg1Tile = new MapTileBuilder(leftg1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftg1Tile);
            
            Frame leftg2Frame = new FrameBuilder(getSubImage(2, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftg2Tile = new MapTileBuilder(leftg2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftg2Tile);
            
            Frame leftg3Frame = new FrameBuilder(getSubImage(2, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftg3Tile = new MapTileBuilder(leftg3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftg3Tile);
            
            Frame leftg4Frame = new FrameBuilder(getSubImage(2, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftg4Tile = new MapTileBuilder(leftg4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftg4Tile);
            
            Frame leftg5Frame = new FrameBuilder(getSubImage(4, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftg5Tile = new MapTileBuilder(leftg5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftg5Tile);
            
            
            
     //side building red
            
            Frame leftrFrame = new FrameBuilder(getSubImage(3, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftrTile = new MapTileBuilder(leftrFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftrTile);
            
            Frame leftr1Frame = new FrameBuilder(getSubImage(3, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftr1Tile = new MapTileBuilder(leftr1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftr1Tile);
            
            Frame leftr2Frame = new FrameBuilder(getSubImage(4, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftr2Tile = new MapTileBuilder(leftr2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftr2Tile);
            
            Frame leftr3Frame = new FrameBuilder(getSubImage(4, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftr3Tile = new MapTileBuilder(leftr3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftr3Tile);
            
            Frame leftr4Frame = new FrameBuilder(getSubImage(4, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftr4Tile = new MapTileBuilder(leftr4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftr4Tile);
            
            Frame leftr5Frame = new FrameBuilder(getSubImage(4, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftr5Tile = new MapTileBuilder(leftr5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftr5Tile);
            
     //side building blue
            
            Frame leftbFrame = new FrameBuilder(getSubImage(0, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftbTile = new MapTileBuilder(leftbFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftbTile);
            
            Frame leftb1Frame = new FrameBuilder(getSubImage(0, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftb1Tile = new MapTileBuilder(leftb1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftb1Tile);
            
            Frame leftb2Frame = new FrameBuilder(getSubImage(1, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftb2Tile = new MapTileBuilder(leftb2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftb2Tile);
            
            Frame leftb3Frame = new FrameBuilder(getSubImage(1, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftb3Tile = new MapTileBuilder(leftb3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftb3Tile);
            
            Frame leftb4Frame = new FrameBuilder(getSubImage(2, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftb4Tile = new MapTileBuilder(leftb4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftb4Tile);
            
            Frame leftb5Frame = new FrameBuilder(getSubImage(2, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder leftb5Tile = new MapTileBuilder(leftb5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(leftb5Tile);
            
     //entrence 
            Frame entFrame = new FrameBuilder(getSubImage(48, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder entTile = new MapTileBuilder(entFrame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(entTile);
            
            Frame ent1Frame = new FrameBuilder(getSubImage(48, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent1Tile = new MapTileBuilder(ent1Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent1Tile);
            
            Frame ent2Frame = new FrameBuilder(getSubImage(48, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent2Tile = new MapTileBuilder(ent2Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent2Tile);
            
            Frame ent3Frame = new FrameBuilder(getSubImage(48, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent3Tile = new MapTileBuilder(ent3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent3Tile);
            
            Frame ent4Frame = new FrameBuilder(getSubImage(48, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent4Tile = new MapTileBuilder(ent4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent4Tile);
            
            Frame ent5Frame = new FrameBuilder(getSubImage(49, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent5Tile = new MapTileBuilder(ent5Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent5Tile);
            
            Frame ent6Frame = new FrameBuilder(getSubImage(49, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent6Tile = new MapTileBuilder(ent6Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent6Tile);
            
            Frame ent7Frame = new FrameBuilder(getSubImage(49, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent7Tile = new MapTileBuilder(ent7Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent7Tile);
            
            Frame ent8Frame = new FrameBuilder(getSubImage(49, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent8Tile = new MapTileBuilder(ent8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent8Tile);
            
            Frame ent9Frame = new FrameBuilder(getSubImage(49, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent9Tile = new MapTileBuilder(ent9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent9Tile);
            
            Frame ent10Frame = new FrameBuilder(getSubImage(50, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent10Tile = new MapTileBuilder(ent10Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent10Tile);
            
            Frame ent11Frame = new FrameBuilder(getSubImage(50, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent11Tile = new MapTileBuilder(ent11Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent11Tile);
            
            Frame ent12Frame = new FrameBuilder(getSubImage(50, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent12Tile = new MapTileBuilder(ent12Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(ent12Tile);
            
            Frame ent13Frame = new FrameBuilder(getSubImage(50, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent13Tile = new MapTileBuilder(ent13Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent13Tile);
            
            Frame ent14Frame = new FrameBuilder(getSubImage(50, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder ent14Tile = new MapTileBuilder(ent14Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(ent14Tile);
            
      //left buildings 
            Frame bildFrame = new FrameBuilder(getSubImage(51, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bildTile = new MapTileBuilder(bildFrame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bildTile);
            
            Frame bild1Frame = new FrameBuilder(getSubImage(51, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild1Tile = new MapTileBuilder(bild1Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild1Tile);
            
            Frame bild2Frame = new FrameBuilder(getSubImage(51, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild2Tile = new MapTileBuilder(bild2Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild2Tile);
            
            Frame bild3Frame = new FrameBuilder(getSubImage(51, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild3Tile = new MapTileBuilder(bild3Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild3Tile);
            
            Frame bild4Frame = new FrameBuilder(getSubImage(51, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild4Tile = new MapTileBuilder(bild4Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild4Tile);
            
            Frame bild5Frame = new FrameBuilder(getSubImage(52, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild5Tile = new MapTileBuilder(bild5Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild5Tile);
            
            Frame bild6Frame = new FrameBuilder(getSubImage(52, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild6Tile = new MapTileBuilder(bild6Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild6Tile);
            
            Frame bild7Frame = new FrameBuilder(getSubImage(52, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild7Tile = new MapTileBuilder(bild7Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild7Tile);
            
            Frame bild8Frame = new FrameBuilder(getSubImage(52, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild8Tile = new MapTileBuilder(bild8Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild8Tile);
            
            Frame bild9Frame = new FrameBuilder(getSubImage(52, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild9Tile = new MapTileBuilder(bild9Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild9Tile);
            
            Frame bild10Frame = new FrameBuilder(getSubImage(53, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild10Tile = new MapTileBuilder(bild10Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild10Tile);
            
            Frame bild11Frame = new FrameBuilder(getSubImage(53, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild11Tile = new MapTileBuilder(bild11Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild11Tile);
            
            Frame bild12Frame = new FrameBuilder(getSubImage(53, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild12Tile = new MapTileBuilder(bild12Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild12Tile);
            
            Frame bild13Frame = new FrameBuilder(getSubImage(53, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild13Tile = new MapTileBuilder(bild13Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild13Tile);
            
            Frame bild14Frame = new FrameBuilder(getSubImage(53, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild14Tile = new MapTileBuilder(bild14Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild14Tile);
            
            Frame bild15Frame = new FrameBuilder(getSubImage(54, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild15Tile = new MapTileBuilder(bild15Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild15Tile);
            
            Frame bild16Frame = new FrameBuilder(getSubImage(54, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild16Tile = new MapTileBuilder(bild16Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild16Tile);
            
            Frame bild17Frame = new FrameBuilder(getSubImage(54, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild17Tile = new MapTileBuilder(bild17Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild17Tile);
            
            Frame bild18Frame = new FrameBuilder(getSubImage(54, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild18Tile = new MapTileBuilder(bild18Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild18Tile);
            
            Frame bild19Frame = new FrameBuilder(getSubImage(54, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild19Tile = new MapTileBuilder(bild19Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild19Tile);
            
            Frame bild20Frame = new FrameBuilder(getSubImage(55, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild20Tile = new MapTileBuilder(bild20Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild20Tile);
            
            Frame bild21Frame = new FrameBuilder(getSubImage(55, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild21Tile = new MapTileBuilder(bild21Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild21Tile);
            
            Frame bild22Frame = new FrameBuilder(getSubImage(55, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder bild22Tile = new MapTileBuilder(bild22Frame)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(bild22Tile);
            
            
            
            
            
     // Sign 
            
            Frame sign1Frame = new FrameBuilder(getSubImage(5, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sign1Tile = new MapTileBuilder(sign1Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(sign1Tile);
            
            Frame sign2Frame = new FrameBuilder(getSubImage(5, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sign2Tile = new MapTileBuilder(sign2Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(sign2Tile);
            
            Frame sign3Frame = new FrameBuilder(getSubImage(5, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sign3Tile = new MapTileBuilder(sign3Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(sign3Tile);
            
            Frame sign4Frame = new FrameBuilder(getSubImage(5, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sign4Tile = new MapTileBuilder(sign4Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(sign4Tile);
            
            Frame sign5Frame = new FrameBuilder(getSubImage(5, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder sign5Tile = new MapTileBuilder(sign5Frame)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(sign5Tile);
                  
        return mapTiles;
    }
}
