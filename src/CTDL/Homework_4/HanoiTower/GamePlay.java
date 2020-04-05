package CTDL.Homework_4.HanoiTower;

import java.awt.event.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class GamePlay extends JPanel {
    JLabel statusbar;

    Stack tower_1 = new Stack();
    Stack tower_2 = new Stack();
    Stack tower_3 = new Stack();

    boolean isSelected_tw1 = true;
    boolean isSelected_tw2 = false;
    boolean isSelected_tw3 = false;

    Block carriedBlock = null;
    boolean isWinner = false;
    int num_block = 0;
    int move = 0;
    int preTower = 1;

    public GamePlay(int n) {
        num_block = n;
        statusbar = new JLabel("Tower of Hanoi");
        add(statusbar, BorderLayout.SOUTH);

        addKeyListener(new KeyBoard());
        setFocusable(true);

        // 30 50 70 90 110 130
        int sizeBlock = 6 * 20 + 10;
        for (int i = 0;i < n;++ i) {
            tower_1.push(new Block(sizeBlock));
            sizeBlock -= 20;
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        // tower 1
        g.fillRect(70, 40, 20, 160);
        // tower 2
        g.fillRect(230, 40, 20, 160);
        // tower 3
        g.fillRect(390, 40, 20, 160);

        // draw tower
        tower_1.drawBlocks(g, 30);
        tower_2.drawBlocks(g, 190);
        tower_3.drawBlocks(g, 350);

        if (tower_3.count() == num_block) {
            isWinner = !isWinner;
            System.out.println("Win!");
            statusbar.setText("You Win with: " + move + " moves, expect: " + (int)(Math.pow(2, num_block) - 1) + " moves. "
                    + "Percent score: " + (float)((Math.pow(2, num_block) - 1) * 100 / (move))  + "%" );
            return;
        }
        else {
            System.out.println(tower_3.count());
            statusbar.setText("Move: " + move);
        }
        //carried block
        if (carriedBlock != null) {
            int xPos = 0;
            if (isSelected_tw1) {
                xPos = 30 + (100 - carriedBlock.getSize()) / 2;
            } else if (isSelected_tw2) {
                xPos = 190 + (100 - carriedBlock.getSize()) / 2;
            } else if (isSelected_tw3) {
                xPos = 350 + (100 - carriedBlock.getSize()) / 2;
            }

            g.setColor(Color.BLUE);
            g.drawRect(xPos, 20, carriedBlock.getSize(), 19);
            g.setColor(Color.RED);
            g.fillRect(xPos + 1, 20 + 1, carriedBlock.getSize() - 1, 18);

        }

        // Selector
        g.setColor(Color.PINK);
        if (isSelected_tw1) {
            g.drawRect(1, 20, 150, 190);
        } else if (isSelected_tw2) {
            g.drawRect(161, 20, 150, 190);
        } else if (isSelected_tw3) {
            g.drawRect(321, 20, 150, 190);
        }

    }

    public class KeyBoard extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            // Catch key for move around Tower
            if (isWinner) return;

            if (key == KeyEvent.VK_RIGHT) {
                System.out.println("Press ->");
                if (isSelected_tw1) {
                    isSelected_tw2 = !isSelected_tw2;
                    isSelected_tw1 = !isSelected_tw1;
                }
                else if (isSelected_tw2) {
                    isSelected_tw2 = !isSelected_tw2;
                    isSelected_tw3 = !isSelected_tw3;
                }
            } else {
                if (key == KeyEvent.VK_LEFT) {
                    System.out.println("Press <-");
                    if (isSelected_tw3) {
                        isSelected_tw3 = !isSelected_tw3;
                        isSelected_tw2 = !isSelected_tw2;
                    }
                    else if (isSelected_tw2) {
                        isSelected_tw2 = !isSelected_tw2;
                        isSelected_tw1 = !isSelected_tw1;
                    }
                }
            }

            if (key == KeyEvent.VK_UP) {
                System.out.println("press up");
                if (carriedBlock ==  null) {
                    if (isSelected_tw1) {
                        preTower = 1;
                        carriedBlock = tower_1.pop();
                    } else if (isSelected_tw2) {
                        preTower = 2;
                        carriedBlock = tower_2.pop();
                    } else if (isSelected_tw3) {
                        preTower = 3;
                        carriedBlock = tower_3.pop();
                    }
                }
            }else if (key ==  KeyEvent.VK_DOWN) {
                if (carriedBlock != null) {
                    boolean isSet = false;
                    if (isSelected_tw1) {
                        if (tower_1.peek() == null || tower_1.peek().getSize() > carriedBlock.getSize()){
                            tower_1.push(carriedBlock);
                            isSet = true;
                            if (preTower != 1) move += 1;
                        }
                    } else if (isSelected_tw2) {
                        if (tower_2.peek() == null || tower_2.peek().getSize() > carriedBlock.getSize()){
                            tower_2.push(carriedBlock);
                            isSet = true;
                            if (preTower != 2) move += 1;
                        }
                    } else if (isSelected_tw3) {
                        if (tower_3.peek() == null || tower_3.peek().getSize() > carriedBlock.getSize()){
                            tower_3.push(carriedBlock);
                            isSet = true;
                            if (preTower != 3) move += 1;
                        }
                    }
                    if (isSet) {
                        carriedBlock = null;

                    }
                }
            }

            repaint();
        }

    }
}