package com.codecool.dungeoncrawl.data.items;

public class Weapon extends Item {
    private int damage = 15;

    public Weapon(String name) {
        super(name);
    }

    public int getDamage() {
        return damage;
    }

}
