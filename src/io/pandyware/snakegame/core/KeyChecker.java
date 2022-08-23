/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.pandyware.snakegame.core;

import static io.pandyware.snakegame.core.Direction.DOWN;
import static io.pandyware.snakegame.core.Direction.LEFT;
import static io.pandyware.snakegame.core.Direction.RIGTH;
import static io.pandyware.snakegame.core.Direction.UP;
import io.pandyware.snakegame.view.GameScreen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author friky
 */
public class KeyChecker implements KeyListener {

  private final GameScreen gameScreen;

  public KeyChecker(GameScreen gameScreen) {
    this.gameScreen = gameScreen;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // repaint();
    // System.out.println("keyTyped");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    Direction direction = this.gameScreen.direction;
    switch (keyCode) {
      case KeyEvent.VK_UP:
        if (direction == LEFT || direction == RIGTH) {
          this.gameScreen.direction = UP;
        }
        break;
      case KeyEvent.VK_DOWN:
        if (direction == LEFT || direction == RIGTH) {
          this.gameScreen.direction = DOWN;
        }
        break;
      case KeyEvent.VK_LEFT:
        if (direction == UP || direction == DOWN) {
          this.gameScreen.direction = LEFT;
        }
        // handle left
        break;
      case KeyEvent.VK_RIGHT:
        if (direction == UP || direction == DOWN) {
          this.gameScreen.direction = RIGTH;
        }
        // handle right
        break;
    }
    // repaint();
    // System.out.println("keyPressed");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // System.out.println("keyReleased");
  }

}
