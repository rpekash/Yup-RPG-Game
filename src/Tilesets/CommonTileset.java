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
        
        
        // blow up man
        Frame[] yBlowupFrames = new Frame[] {
            new FrameBuilder(getSubImage(8, 1), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(8, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(8, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(8, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(8, 3), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(8, 4), 500)
                    .withScale(tileScale)
                    .build(),
            
        };

        MapTileBuilder yBlowupTile = new MapTileBuilder(yBlowupFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(yBlowupTile);
        
     // blow up man
        Frame[] bBlowupFrames = new Frame[] {
            new FrameBuilder(getSubImage(9, 0), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 1), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 1), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 2), 500)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(9, 3), 500)
                    .withScale(tileScale)
                    .build(),
            
        };

        MapTileBuilder bBlowupTile = new MapTileBuilder(bBlowupFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bBlowupTile);
        
        

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
