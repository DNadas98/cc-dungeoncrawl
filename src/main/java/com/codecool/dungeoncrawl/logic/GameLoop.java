package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.ui.UI;
import javafx.application.Platform;

/*
Threads in Java: https://www.youtube.com/watch?v=r_MbozD32eo
Runnable: https://www.geeksforgeeks.org/runnable-interface-in-java/
volatile: latest update is visible on all threads (r/w into main memory, not cached locally)
  https://www.baeldung.com/java-volatile
Platform.runLater:
  ui update must be called on javafx thread
  https://docs.oracle.com/javase/8/javafx/api/javafx/application/Platform.html#runLater-java.lang.Runnable-
*/

public class GameLoop implements Runnable{
  private final Thread thread;
  private final GameLogic logic;
  private final UI ui;
  private volatile boolean exitCondition;
  private final int FPS;
  private volatile boolean isRendering = false;

  public GameLoop(GameLogic logic, UI ui, int FPS) {
    this.logic = logic;
    this.FPS = FPS;
    this.thread = new Thread(this);
    this.ui=ui;
    this.exitCondition= false;
  }

  @Override
  public void run() {
      while (!exitCondition) {
        try {
          while(isRendering) {
            Thread.sleep(5);
          }
          handleAILogic();
          handleUIUpdate();

          if (isOver()){
            exitCondition=true;
          }

          Thread.sleep(1000/FPS);
        } catch (InterruptedException e) {
          this.exitCondition = true;
          System.out.println("Error: "+e.getMessage());
          e.printStackTrace();
        }
      }
  }

  public void start(){
    thread.start();
  }

  public void stop() {
    this.exitCondition = true;
  }

  private boolean isOver(){
    return logic.playerHasWon() || logic.playerIsDead();
  }

  private void handleAILogic(){
    logic.handleLogicOfAllNPCs();
  }

  private void handleUIUpdate(){
    isRendering = true;
    Platform.runLater(() -> {
      ui.refresh();
      isRendering = false;
    });
  }
}
