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
        super(ImageLoader.load("CommonTileset.png"), 16, 16, 3);
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
            /*******************************************************/
            //desert house
            /*******************************************************/
            Frame dhouse1 = new FrameBuilder(getSubImage(12, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse1Tile = new MapTileBuilder(dhouse1)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse1Tile);
            /*******************************************************/
            Frame dhouse2 = new FrameBuilder(getSubImage(12, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse2Tile = new MapTileBuilder(dhouse2)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse2Tile);
            /*******************************************************/
            Frame dhouse3 = new FrameBuilder(getSubImage(13, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse3Tile = new MapTileBuilder(dhouse3)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse3Tile);
            /*******************************************************/
            Frame dhouse4 = new FrameBuilder(getSubImage(13, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse4Tile = new MapTileBuilder(dhouse4)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse4Tile);
            /*******************************************************/
            Frame dhouse5 = new FrameBuilder(getSubImage(13, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse5Tile = new MapTileBuilder(dhouse5)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse5Tile);
            /*******************************************************/
            Frame dhouse6 = new FrameBuilder(getSubImage(13, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse6Tile = new MapTileBuilder(dhouse6)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse6Tile);
            /*******************************************************/
            Frame dhouse7 = new FrameBuilder(getSubImage(13, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse7Tile = new MapTileBuilder(dhouse7)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse7Tile);
            /*******************************************************/
            Frame dhouse8 = new FrameBuilder(getSubImage(14, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse8Tile = new MapTileBuilder(dhouse8)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse8Tile);
            /*******************************************************/
            Frame dhouse9 = new FrameBuilder(getSubImage(14, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse9Tile = new MapTileBuilder(dhouse9)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse9Tile);
            /*******************************************************/
            Frame dhouse10 = new FrameBuilder(getSubImage(14, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse10Tile = new MapTileBuilder(dhouse10)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse10Tile);
            /*******************************************************/
            Frame dhouse11 = new FrameBuilder(getSubImage(14, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse11Tile = new MapTileBuilder(dhouse11)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse11Tile);
            /*******************************************************/
            Frame dhouse12 = new FrameBuilder(getSubImage(14, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse12Tile = new MapTileBuilder(dhouse12)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse12Tile);
            /*******************************************************/
            Frame dhouse13 = new FrameBuilder(getSubImage(15, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse13Tile = new MapTileBuilder(dhouse13)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse13Tile);
            /*******************************************************/
            Frame dhouse14 = new FrameBuilder(getSubImage(15, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse14Tile = new MapTileBuilder(dhouse14)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse14Tile);
            /*******************************************************/
            Frame dhouse15 = new FrameBuilder(getSubImage(15, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse15Tile = new MapTileBuilder(dhouse15)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse15Tile);
            /*******************************************************/            
            Frame dhouse16 = new FrameBuilder(getSubImage(15, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse16Tile = new MapTileBuilder(dhouse16)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse16Tile);
            /*******************************************************/            
            Frame dhouse17 = new FrameBuilder(getSubImage(15, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse17Tile = new MapTileBuilder(dhouse17)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse17Tile);
            /*******************************************************/            
            Frame dhouse18 = new FrameBuilder(getSubImage(16, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse18Tile = new MapTileBuilder(dhouse18)
                    .withTileType(TileType.PASSABLE);
            mapTiles.add(dhouse18Tile);
            /*******************************************************/            
            Frame dhouse19 = new FrameBuilder(getSubImage(16, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse19Tile = new MapTileBuilder(dhouse19)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse19Tile);
            /*******************************************************/           
            Frame dhouse20 = new FrameBuilder(getSubImage(16, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse20Tile = new MapTileBuilder(dhouse20)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse20Tile);
            /*******************************************************/           
            Frame dhouse21 = new FrameBuilder(getSubImage(16, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse21Tile = new MapTileBuilder(dhouse21)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse21Tile);
            /*******************************************************/           
            Frame dhouse22 = new FrameBuilder(getSubImage(16, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse22Tile = new MapTileBuilder(dhouse22)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse22Tile);
            /*******************************************************/           
            Frame dhouse23 = new FrameBuilder(getSubImage(17, 0))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse23Tile = new MapTileBuilder(dhouse23)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse23Tile);
            /*******************************************************/           
            Frame dhouse24 = new FrameBuilder(getSubImage(17, 1))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse24Tile = new MapTileBuilder(dhouse24)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse24Tile);
            /*******************************************************/           
            Frame dhouse25 = new FrameBuilder(getSubImage(17, 2))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse25Tile = new MapTileBuilder(dhouse25)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse25Tile);
            /*******************************************************/           
            Frame dhouse26 = new FrameBuilder(getSubImage(17, 3))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse26Tile = new MapTileBuilder(dhouse26)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse26Tile);
            /*******************************************************/           
            Frame dhouse27 = new FrameBuilder(getSubImage(17, 4))
                    .withScale(tileScale)
                    .build();
            MapTileBuilder dhouse27Tile = new MapTileBuilder(dhouse27)
                    .withTileType(TileType.NOT_PASSABLE);
            mapTiles.add(dhouse27Tile);
            
            
            
            
            
        // top water
//        Frame[] topWaterFrames = new Frame[] {
//            new FrameBuilder(getSubImage(5, 0), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 1), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 2), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 1), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 0), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 3), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 4), 500)
//                    .withScale(tileScale)
//                    .build(),
//            new FrameBuilder(getSubImage(5, 3), 500)
//                    .withScale(tileScale)
//                    .build()
//        };

//        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(topWaterTile);
//        
        return mapTiles;
    }
}
