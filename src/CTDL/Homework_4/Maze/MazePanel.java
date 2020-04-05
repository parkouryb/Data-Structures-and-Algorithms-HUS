package CTDL.Homework_4.Maze;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import java.awt.event.MouseEvent;
import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class MazePanel extends JFrame{
    Maze maze = new Maze();
    int[][] mazee = maze.getMaze();
    boolean[][] boolMazee = new boolean[mazee.length][mazee[0].length];
    
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    Node nodeStanding;

    public MazePanel() {
        addKeyListener(new KeyBoard());
        setFocusable(true);
        
        setTitle("Maze Solver");
        nodeStanding = maze.startPoint;

        boolean canFind = maze.findWay();
        System.out.println("Could find Way: " + canFind);
        if (canFind) {
            maze.backTracking(maze.endPoint);
            maze.printBacktrack();
        }

        
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        // draw maze
        for (int i = 0;i < mazee.length;++ i) {
            for (int j = 0;j < mazee[i].length;++ j) {
                Color color = Color.BLUE;
                if (mazee[i][j] == 1) {
                    color = Color.black;
                } else if (mazee[i][j] == 2) {
                    color = Color.pink;
                } else if (mazee[i][j] == 0) {
                    color = Color.white;
                } else if (mazee[i][j] == 3) {
                    color = Color.red;
                } else if (mazee[i][j] == 9) {
                    color = Color.ORANGE;
                }

                g.setColor(color);
                g.fillRect(30 * (j + 1), 30 * (i + 1), 30, 30);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(30 * (j + 1), 30 * (i + 1), 30, 30);

            }
        }

        // draw node_standing
        g.setColor(Color.blue);
        g.drawRect((nodeStanding.x + 1) * 30, (nodeStanding.y + 1) * 30, 30, 30);
        g.setColor(Color.green);
        g.fillRect((nodeStanding.x + 1) * 30 + 1, (nodeStanding.y + 1) * 30 + 1, 29, 29);

        
    }

    public boolean canGo(int x, int y) {
        return mazee[y][x] != 1;
    }

    public class KeyBoard extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            // Catch key for move around Tower
            switch (key) {
                case KeyEvent.VK_DOWN: {
                    System.out.println("press down");
                    if (canGo(nodeStanding.x, nodeStanding.y + 1)) {
                        nodeStanding = new Node(nodeStanding.x, nodeStanding.y + 1);

                    }
                    break;
                }
                case KeyEvent.VK_UP: {
                    System.out.println("press up");
                    if (canGo(nodeStanding.x, nodeStanding.y - 1)) {
                        nodeStanding = new Node(nodeStanding.x, nodeStanding.y - 1);

                    }
                    break;
                }

                case KeyEvent.VK_LEFT: {
                    System.out.println("press left");
                    if (canGo(nodeStanding.x - 1, nodeStanding.y)) {
                        nodeStanding = new Node(nodeStanding.x - 1, nodeStanding.y);

                    }
                    break;
                }

                case KeyEvent.VK_RIGHT: {
                    System.out.println("press right");
                    if (canGo(nodeStanding.x + 1, nodeStanding.y)) {
                        nodeStanding = new Node(nodeStanding.x + 1, nodeStanding.y);

                    }
                    break;
                }
                default: {}
                    
            }

            repaint();
        } 
        
    }
}