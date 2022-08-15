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
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author friky
 */
public class GameScreen extends JFrame {

  private final ArrayList<Point> points;
  public Direction direction;
  private final int DISTANCE = 10;
  private final Point newHead;

  public GameScreen() {
    this.direction = Direction.RIGTH;
    this.newHead = new Point(190, 190);
    points = new ArrayList();
    points.add(new Point(170, 60));
    points.add(new Point(160, 60));
    points.add(new Point(150, 60));
    setSize(500, 500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    setBackground(Color.yellow);
    addKeyListener(new KeyChecker(this));
    this.initThread();
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    drawSnake(graphics);
    graphics.fillRect(this.newHead.getX(), this.newHead.getY(), 10, 10);
    System.out.println("paintComponent");

  }
  
  private void drawSnake(Graphics graphics) {
      for (int i = 0; i < this.points.size(); i++) {
      Point point = points.get(i);
      System.out.println(point);
      graphics.fillRect(point.getX(), point.getY(), 10, 10);
    } 
  }

  private void updateBody(Point previous) {
    System.out.println("Size: " + points.size());
    for (int i = 1; i < this.points.size(); i++) {
      int x = previous.getX();
      int y = previous.getY();
      Point point = this.points.get(i);
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
  
  public void checkFood() {
    Point head = this.points.get(0);
    if (this.newHead.getX() == head.getX() && this.newHead.getY() == head.getY()) {
      this.points.add(0, new Point(this.newHead.getX(), this.newHead.getY()));
      this.newHead.setX(this.randomNumber() * 10);
      this.newHead.setY(this.randomNumber() * 10);
      System.out.println("Food");
    }
  }
  
  private int randomNumber() {
    return ThreadLocalRandom.current().nextInt(0, 40 + 1);
  }

}
