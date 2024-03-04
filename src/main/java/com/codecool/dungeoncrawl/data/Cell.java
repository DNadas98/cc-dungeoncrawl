package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private List<Item> items;
    private GameMap gameMap;
    private int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
        this.items=new ArrayList<>();
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public void addItem(Item item) {
        System.out.println("addItem: "+item);
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public List<Cell> getAllNeighbours() {
        return List.of(
                gameMap.getCell(x+1, y),
                gameMap.getCell(x-1, y),
                gameMap.getCell(x, y+1),
                gameMap.getCell(x, y-1),
                gameMap.getCell(x+1, y+1),
                gameMap.getCell(x+1, y-1),
                gameMap.getCell(x-1, y+1),
                gameMap.getCell(x-1, y-1)
        );
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
