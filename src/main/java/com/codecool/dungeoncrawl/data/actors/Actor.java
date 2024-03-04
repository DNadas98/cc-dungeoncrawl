package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health;
    private int damage;

    protected List<Item> inventory;

    public Actor(Cell cell, int health, int damage) {
        this.cell = cell;
        this.health = health;
        this.damage = damage;
        this.cell.setActor(this);
        this.inventory=new ArrayList<>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth){
        this.health=newHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public List<Item> getInventory(){
        return List.copyOf(inventory);
    }

    public void addToInventory(Item item){
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

}
