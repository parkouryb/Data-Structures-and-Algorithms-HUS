package CTDL.Homework_4.Maze;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MazeEx {

    public static void main(String[] agrs) {
        Maze maze = new Maze();
        maze.printConsole();
        // System.out.println("Could find Way: " + maze.findWay());
        // maze.backTracking(maze.endPoint);
        
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    MazePanel mazePanel = new MazePanel();
                    mazePanel.setVisible(true);
                }catch (Exception e) {
                    System.out.println("Somethings Wrong");
                }
            }
        });
    }
}