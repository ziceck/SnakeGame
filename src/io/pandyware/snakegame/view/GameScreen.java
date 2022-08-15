/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.pandyware.snakegame.view;

import io.pandyware.snakegame.core.Direction;
import io.pandyware.snakegame.core.KeyChecker;
import io.pandyware.snakegame.core.Point;
import io.pandyware.snakegame.core.SnakeController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author friky
 */
public class GameScreen extends JFrame {

  private final ArrayList<Point> points;
  private final JPanel gamePanel;
  public Direction direction;
  private final int DISTANCE = 5;

  public GameScreen() {
    this.direction = Direction.RIGTH;
    gamePanel = new GamePanel();
    points = new ArrayList();
    points.add(new Point(169, 62));
    setSize(500, 500);
    add(gamePanel);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setBackground(Color.yellow);
    addKeyListener(new KeyChecker(this));
    this.initThread();
  }

  public JPanel getGamePanel() {
    return this.gamePanel;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    System.out.println("paintComponent");
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      System.out.println(point.getX());
      graphics.fillRect(point.getX(), point.getY(), 10, 10);
    }
    // this.graphics = graphics;
    // super.paintComponent(graphics);
    // graphics.fillRect(200, 62, 30, 10);
  }

  public void moveRigth() {
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      point.setX(point.getX() + this.DISTANCE);
      System.out.println(point);
    }
  }

  public void moveLeft() {
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      point.setX(point.getX() - this.DISTANCE);
      System.out.println(point);
    }
  }

  public void moveUp() {
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      point.setY(point.getY() - this.DISTANCE);
      System.out.println(point);
    }
  }

  public void moveDown() {
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      point.setY(point.getY() + this.DISTANCE);
      System.out.println(point);
    }
  }

  private void initThread() {
    new Thread(new SnakeController(this)).start();
  }

}
