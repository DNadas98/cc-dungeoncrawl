package com.codecool.dungeoncrawl.data.items;

public class Armour extends Item {
    int protection = 20;

    public Armour(String name) {
        super(name);
    }

    public int getProtection() {
        return protection;
    }
}
