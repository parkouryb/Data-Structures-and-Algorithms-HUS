package CTDL.Homework_4.HanoiTower;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GamePanel extends JFrame {
    /**
     * run game
     */
    public static void main(String[] agrs) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    int n = 3;
                    GamePanel gamePanel = new GamePanel(n);
                    gamePanel.setVisible(true);
                }catch (Exception e) {
                    System.out.println("Somethings Wrong");
                }
            }
        });
    }

    public GamePanel(int n) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 490, 300);

        setContentPane(new GamePlay(n));
    }
}