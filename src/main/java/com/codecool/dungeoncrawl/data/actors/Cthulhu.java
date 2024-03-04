package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.List;

public class Cthulhu extends Npc {

    public Cthulhu(Cell cell) {
        super(cell, 50, 6, 7);
        this.inventory = List.of(new Key("Cthulhu key",this.getCell()));
    }

    @Override
    public String getTileName() {
        return "Cthulhu";
    }
}
