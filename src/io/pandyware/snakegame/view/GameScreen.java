/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.pandyware.snakegame.view;

import io.pandyware.snakegame.core.Direction;
import io.pandyware.snakegame.core.KeyChecker;
import io.pandyware.snakegame.core.Point;
import io.pandyware.snakegame.core.SnakeController;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
    points.add(new Point(170, 62));
    points.add(new Point(171, 62));
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
      System.out.println(point);
      graphics.fillRect(point.getX(), point.getY(), 10, 10);
    }
  }

  private void updateBody(Point previous) {
    System.out.println("Size: " + points.size());
    for (int i = 1; i < points.size(); i++) {
      int x = previous.getX();
      int y = previous.getY();
      Point point = points.get(i);
      previous.setX(point.getX());
      previous.setY(point.getY());
      point.setX(x);
      point.setY(y);
      System.out.println(point);
    }
  }

  public void moveRigth() {
    Point head = points.get(0);
    Point previous = new Point(head.getX(), head.getY());
    head.setX(head.getX() + this.DISTANCE);
    updateBody(previous);
  }

  public void moveLeft() {
    Point head = points.get(0);
    Point previous = new Point(head.getX(), head.getY());
    head.setX(head.getX() - this.DISTANCE);
    updateBody(previous);
  }

  public void moveUp() {
    Point head = points.get(0);
    Point previous = new Point(head.getX(), head.getY());
    head.setY(head.getY() - this.DISTANCE);
    updateBody(previous);
  }

  public void moveDown() {
    Point head = points.get(0);
    Point previous = new Point(head.getX(), head.getY());
    head.setY(head.getY() + this.DISTANCE);
    this.updateBody(previous);
  }

  private void initThread() {
    new Thread(new SnakeController(this)).start();
  }

}
