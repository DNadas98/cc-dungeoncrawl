package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Npc;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameLogic {
  private GameMap map;

  public GameLogic() {
    this.map = MapLoader.loadMap();
  }

  public double getMapWidth() {
    return map.getWidth();
  }

  public double getMapHeight() {
    return map.getHeight();
  }

  public void setup() {
  }

  public Cell getCell(int x, int y) {
    return map.getCell(x, y);
  }

  public String getPlayerHealth() {
    if(map.getPlayer().getHealth()>0) {
      int fullHP = map.getPlayer().getHealth() + map.getPlayer().getHpBonus();
      return Integer.toString(fullHP);
    } else return Integer.toString(0);
  }
  public String getPlayerDamage() {
    return Integer.toString(map.getPlayer().getDamage());
  }
  public String getPlayerBlock() {
    return Integer.toString(map.getPlayer().getBlock());
  }
  public List<String> getPlayerInventory() {
    List<String> inventoryTexts = new ArrayList<>();
    for(Item item : map.getPlayer().getInventory()){
      inventoryTexts.add(item.getName());
    }
    return inventoryTexts;
  }


  public GameMap getMap() {
    return map;
  }

  public boolean playerIsDead(){
    return map.getPlayer().getHealth()<=0;
  }

  public boolean playerHasWon(){
    return map.getPlayer().getCell().getType()==CellType.END_GAME_OPEN;
  }

  public void handleLogicOfAllNPCs() {
    List<Npc> npcList = getAllNPCs();
    for (Npc npc : npcList) {
      Optional<Cell> detectedPlayerCell = lookForPlayerCell(npc);
      npc.moveNpc(detectedPlayerCell);
      if (detectedPlayerCell.isPresent() &&
              npc.getCell().getAllNeighbours().contains(detectedPlayerCell.get())){
        damagePlayer((Player) detectedPlayerCell.get().getActor(),npc);
      }
    }
  }

  private void damagePlayer(Player player, Npc npc){
    int damage = npc.getDamage();
    if (!player.playerHasBlocked()) {
      if (player.getHealth()+player.getHpBonus() - damage >= 0) {
        player.setHealth(player.getHealth() - damage);
      } else {
        player.setHealth(0);
      }
    }
  }

  private List<Npc> getAllNPCs() {
    List<Npc> npcList = new ArrayList<>();
    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        Cell currentCell = map.getCell(i, j);
        if (currentCell.getActor() instanceof Npc) {
          npcList.add((Npc) currentCell.getActor());
        }
      }
    }
    return npcList;
  }

  private Optional<Cell> lookForPlayerCell(Npc npc) {
    int detectDistance = npc.getDetectDistance();

    Cell npcCell = npc.getCell();
    Cell detectedPlayerCell = map.getPlayer().getCell();

    double dx = detectedPlayerCell.getX() - npcCell.getX();
    double dy = detectedPlayerCell.getY() - npcCell.getY();
    double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    if(distance <= detectDistance) {
      return Optional.of(detectedPlayerCell);
    } else{
      return Optional.empty();
    }
  }
}
