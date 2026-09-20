/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw_lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hangman extends JPanel{
    private int xShift = 0;

    public Hangman() {
        
        setFocusable(true);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    xShift -= 10; 
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xShift += 10; 
                    repaint();
                }
            }
        });
}

@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int radius = 20;

        g.drawArc(20 + xShift, 220, 80, 40, 0, 180);
        g.drawLine(20 + 40 + xShift, 220, 20 + 40 + xShift, 20);
        g.drawLine(20 + 40 + xShift, 20, 20 + 40 + 100 + xShift, 20);
        g.drawLine(20 + 40 + 100 + xShift, 20, 20 + 40 + 100 + xShift, 40);

        g.drawOval(20 + 40 + 100 - radius + xShift, 40, 2 * radius, 2 * radius);

        g.drawLine(20 + 40 + 100 - (int)(radius * Math.cos(Math.toRadians(45))) + xShift,
                   40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                   20 + 40 + 100 - 60 + xShift, 
                   40 + radius + 60);

        g.drawLine(20 + 40 + 100 + (int)(radius * Math.cos(Math.toRadians(45))) + xShift,
                   40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                   20 + 40 + 100 + 60 + xShift, 
                   40 + radius + 60);

        g.drawLine(20 + 40 + 100 + xShift, 40 + 2 * radius, 20 + 40 + 100 + xShift, 40 + radius + 80);

        g.drawLine(20 + 40 + 100 + xShift, 40 + radius + 80, 20 + 40 + 100 - 40 + xShift, 40 + radius + 80 + 40);

        g.drawLine(20 + 40 + 100 + xShift, 40 + radius + 80, 20 + 40 + 100 + 40 + xShift, 40 + radius + 80 + 40);
    }
}

class Main{
    public static void main(String[] args) {
        JFrame frame=new JFrame("Hangman Game");
        Hangman hm=new Hangman();
        frame.add(hm);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        hm.requestFocusInWindow();
    }
}