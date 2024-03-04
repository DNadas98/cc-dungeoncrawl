package com.codecool.dungeoncrawl.data.items;


import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.UUID;

public class Key extends Item implements Drawable {

    public Key(String name, Cell cell) {
        super(name);
    }

    @Override
    public String getTileName() {
        return "key";

    }
}
