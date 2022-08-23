/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.pandyware.snakegame.core;

import io.pandyware.snakegame.view.GameScreen;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author friky
 */
public class SnakeController implements Runnable {
  
  private final GameScreen gameScreen;
  
  public SnakeController(GameScreen gameScreen) {
    this.gameScreen = gameScreen;
  }

  @Override
  public void run() {
    while (true) {
      this.gameScreen.checkFood();
      switch (this.gameScreen.direction) {
        case RIGTH:
          this.gameScreen.moveRigth();
          break;
        case DOWN:
          this.gameScreen.moveDown();
          break;

        case LEFT:
          this.gameScreen.moveLeft();
          break;

        case UP:
          this.gameScreen.moveUp();
          break;
      }
      try {
        this.gameScreen.repaint();
        sleep(100);
      } catch (InterruptedException ex) {
        Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

}
