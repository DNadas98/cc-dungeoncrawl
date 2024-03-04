package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public abstract class Npc extends Actor {
  private final Random random;
  private final int detectDistance;

  public Npc(Cell cell, int health, int damage, int detectDistance) {
    super(cell, health, damage);
    this.detectDistance = detectDistance;
    this.random = new Random();
  }

  public int getDetectDistance() {
    return detectDistance;
  }

  public void dropLoot() {
    Cell location = this.getCell();
    List<Item> loot = this.getInventory();
    for (Item item : loot) {
      location.addItem(item);
      System.out.println("dropLoot: "+item);
    }
  }

  public void moveNpc(Optional<Cell> detectedPlayerCell) {
    Cell nextCell;
    if (detectedPlayerCell.isPresent()) {
      nextCell = getNextCellTowards(detectedPlayerCell.get());
    } else {
      nextCell = getValidRandomCell();
    }
    if (nextCell!=null) {
      handleMovementCells(nextCell);
    }
  }

  private void handleMovementCells(Cell nextCell) {
    cell.setActor(null);
    nextCell.setActor(this);
    cell = nextCell;
  }

  private boolean isValidCellToMoveTo(Cell cellToCheck) {
    return (cellToCheck.getType().equals(CellType.FLOOR)
            || cellToCheck.getType().equals(CellType.OPEN_DOOR))
            && cellToCheck.getActor() == null;
  }

  private Cell getValidRandomCell() {
    Cell nextCell = null;
    while (nextCell == null) {
      int dx = random.nextInt(3) - 1;
      int dy = random.nextInt(3) - 1;
      Cell cellToCheck = cell.getNeighbor(dx, dy);
      if (isValidCellToMoveTo(cellToCheck)) {
        nextCell = cellToCheck;
      }
    }
    return nextCell;
  }

  private Cell getNextCellTowards(Cell playerCell) {
    Cell nextCell = null;
    int attempts = 0;
    int maxAttempts = 8; //8 cells around a cell
    while (nextCell == null && attempts <= maxAttempts) {
      int dx = playerCell.getX() - cell.getX();
      int dy = playerCell.getY() - cell.getY();

      int moveToX = 0, moveToY = 0;
      if (dx > 0) {
        moveToX = 1;
      } else if (dx < 0) {
        moveToX = -1;
      }
      if (dy > 0) {
        moveToY = 1;
      } else if (dy < 0) {
        moveToY = -1;
      }

      Cell cellToCheck = cell.getNeighbor(moveToX, moveToY);
      if (isValidCellToMoveTo(cellToCheck)) {
        nextCell = cellToCheck;
      }
      attempts++;
    }
    return nextCell;
  }
}
