package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Fight implements KeyHandler {
  public static final KeyCode code = KeyCode.F;

  @Override
  public void perform(KeyEvent event, GameMap map) {
    if (code.equals(event.getCode())) {
      map.getPlayer().fight();
    }
  }
}