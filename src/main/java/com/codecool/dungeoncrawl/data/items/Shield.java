package com.codecool.dungeoncrawl.data.items;

public class Shield extends Item {
    int block = 5;

    public Shield(String name) {
        super(name);
    }

    public int getBlock() {
        return block;
    }
}
