package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Armour;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Shield;
import com.codecool.dungeoncrawl.data.items.Weapon;

import java.util.List;
import java.util.Random;

public class Skeleton extends Npc {

    private List<Item> possibleItems = List.of(new Weapon("axe"), new Armour("armour"), new Shield("shield"));
    private Random random;
    public Skeleton(Cell cell) {
        super(cell, 10, 4, 5);
        this.random = new Random();
        this.inventory = List.of(possibleItems.get(random.nextInt(possibleItems.size())));
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

}
