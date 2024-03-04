package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import com.codecool.dungeoncrawl.data.items.*;

import java.util.List;
import java.util.SplittableRandom;

public class Player extends Actor {
    private int block = 0;
    private int hpBonus=0;
    private int dmgBonus =0;

    public Player(Cell cell) {
        super(cell, 40,5);
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }
    public int getHpBonus(){
        return hpBonus;
    }

    @Override
    public int getDamage() {
        return super.getDamage()+dmgBonus;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    private void handleItemBonuses() {
        for (Item item: inventory){
            if (item instanceof Weapon) {
                int currentDmgBonus =((Weapon) item).getDamage();
                if(currentDmgBonus>this.dmgBonus){
                    System.out.println("Damage bonus: "+dmgBonus);
                    this.dmgBonus=currentDmgBonus;
                    System.out.println("Damage bonus: "+dmgBonus);
                }
            } else if (item instanceof Armour) {
                int currentHpBonus=((Armour) item).getProtection();
                if (currentHpBonus>this.hpBonus){
                    System.out.println("HP bonus: "+hpBonus);
                    this.hpBonus=currentHpBonus;
                    System.out.println("HP bonus: "+hpBonus);
                }
            } else if (item instanceof Shield) {
                int currentBlock=((Shield) item).getBlock();
                if (currentBlock>this.block){
                    System.out.println("Block: "+block);
                    this.block=currentBlock;
                    System.out.println("Block: "+block);
                }
            }
        }
    }

    public boolean playerHasBlocked() {
        SplittableRandom random = new SplittableRandom();
        double randomValue = random.nextDouble();
        double scaledValue = randomValue * 100;
        return scaledValue < this.getBlock();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if ((nextCell.getType().equals(CellType.FLOOR)
                || nextCell.getType().equals(CellType.OPEN_DOOR)
                || nextCell.getType().equals(CellType.END_GAME_OPEN))
                && nextCell.getActor()==null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void interact() {
        List<Cell> neighbouringCells = this.getCell().getAllNeighbours();
        System.out.println("Interact");
        boolean playerHasKey = !this.getInventory().isEmpty() && this.getInventory().stream().anyMatch(item -> item instanceof Key);
        neighbouringCells.forEach(cell -> {
            if (cell.getType().equals(CellType.FLOOR)) {
                if (!cell.getItems().isEmpty()){
                    cell.getItems().forEach(item-> {
                        addToInventory(item);
                        cell.removeItem(item);
                        System.out.println("loot in interact: "+item);
                        this.handleItemBonuses();
                    });
                }
            } else if ((cell.getType().equals(CellType.CLOSED_DOOR)) && playerHasKey){
                inventory.remove(inventory.stream().filter(item -> item instanceof Key).findFirst().get());
                cell.setType(CellType.OPEN_DOOR);
            } else if ((cell.getType().equals(CellType.END_GAME))&& playerHasKey){
                cell.setType(CellType.END_GAME_OPEN);
            }
        });
    }

    public void fight() {
        List<Cell> neighbouringTiles = this.getCell().getAllNeighbours();
        System.out.println("Fight");
        neighbouringTiles.forEach(tile -> {
            if (tile.getActor() instanceof Npc) {
                Npc monster = (Npc) tile.getActor();
                if (monster.getHealth() > 0) {
                    monster.setHealth(monster.getHealth() - this.getDamage());
                } else {
                    System.out.println("npc is dead");
                    if (!monster.getInventory().isEmpty()) {
                        monster.dropLoot();
                        System.out.println("loot: " + tile.getItems());
                    }
                    tile.setActor(null);
                }
            }
        });
    }

}
