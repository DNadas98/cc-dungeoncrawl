package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.List;

public class Owl extends Npc {

    public Owl(Cell cell) {
        super(cell, 20, 5, 6);
        this.inventory = List.of(new Key("Owl key",this.getCell()));
    }

    @Override
    public String getTileName() { return "The Owl with a Copper Chopper"; }
}
