package com.codecool.dungeoncrawl.data;

public enum CellType implements Drawable{
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    CLOSED_DOOR("closedDoor"),
    OPEN_DOOR("openDoor"),
    LOOT_CHEST("lootChest"),
    END_GAME("endGame"),
    END_GAME_OPEN("endGameOpen");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    @Override
    public String getTileName() {
        return tileName;
    }
}
