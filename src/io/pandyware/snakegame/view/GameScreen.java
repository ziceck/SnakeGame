/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.pandyware.snakegame.view;

import io.pandyware.snakegame.core.Point;
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
    
    
    private ArrayList<Point> points;
    private final JPanel gamePanel;
    private int direction = 0;
    
    public GameScreen() {
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
        addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {
               // repaint();
               System.out.println("keyTyped");
           }

           @Override
           public void keyPressed(KeyEvent e) {
               // repaint();
                System.out.println("keyPressed");
           }

           @Override
           public void keyReleased(KeyEvent e) {
               move();
               repaint();
               System.out.println("keyReleased");
           }
        });
       
    }
    
    public JPanel getGamePanel() {
        return this.gamePanel;
    }
    
    @Override
    public void paint(Graphics graphics) {
        System.out.println("paintComponent");
        for (int i = 0; i < points.size(); i ++) {
            Point point = points.get(i);
            graphics.fillRect(point.getX(), point.getY(), 10, 10);
        }
        // this.graphics = graphics;
        // super.paintComponent(graphics);
        // graphics.fillRect(200, 62, 30, 10);
    }
    
    public void move() {
        for (int i = 0; i < points.size(); i ++) {
          Point point = points.get(i);
          point.setX(this.getX() + 1);
        }
    }
    
}
