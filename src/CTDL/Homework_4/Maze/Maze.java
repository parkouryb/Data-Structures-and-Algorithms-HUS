package CTDL.Homework_4.Maze;

import java.util.*;
import java.io.*;

public class Maze{

    // private int[][] maze = {
    //     {1, 1, 1, 1, 1, 1, 1, 1, 1},
    //     {1, 2, 1, 1, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 1, 0, 1, 0, 0, 1},
    //     {1, 1, 0, 0, 0, 1, 1, 1, 1},
    //     {1, 0, 1, 0, 0, 0, 0, 0, 1},
    //     {1, 0, 0, 1, 0, 1, 0, 1, 1},
    //     {1, 0, 0, 0, 0, 1, 0, 3, 1},
    //     {1, 1, 1, 1, 1, 1, 1, 1, 1}
    // };

    private int [][] maze = 
    { {1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,2,1,0,1,0,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,1,0,1,1,1,0,1},
      {1,0,0,0,1,1,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,0,0,1,1,1,0,1},
      {1,0,1,0,1,1,1,0,1,0,0,0,1},
      {1,0,1,0,1,0,0,0,1,1,1,1,1},
      {1,0,1,0,1,1,1,0,1,0,1,0,1},
      {1,0,0,0,0,0,0,0,0,0,1,3,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1}
    
    };
    public Node startPoint = new Node(1, 1);
    public Node endPoint = new Node(8, 11);
        //new Node(6, 7);
        //new Node(8, 11);

    private boolean[][] boolMaze;
    private Node[][] backtrack;

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    private Stack<Node> stack = new Stack<Node>();

    public Maze() {
        boolMaze = new boolean[maze.length][maze[0].length];
        backtrack = new Node[maze.length][maze[0].length];
        
        for (int i = 0;i < maze.length;++ i) {
            for (int j = 0;j < maze[i].length;++ j) {

                backtrack[i][j] = new Node(0, 0); // memset backtrack
                
                // memset boolMaze
                if (maze[i][j] == 0 || maze[i][j] == 2 || maze[i][j] == 3) boolMaze[i][j] = true;
                else boolMaze[i][j] = false;
                
            }
        }
        backtrack[startPoint.x][startPoint.y] = new Node(-1, -1);

    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public void printConsole()  {
        for (int i = 1;i < maze.length - 1;++ i) {
            for (int j = 1;j < maze[i].length - 1;++ j) {
                if (maze[i][j] == 0) System.out.print(".");
                if (maze[i][j] == 1) System.out.print("#");
                if (maze[i][j] == 2) System.out.print("@");
                if (maze[i][j] == 3) System.out.print("$");
                if (maze[i][j] == 9) System.out.print("!");
                
            }
            System.out.print("\n");
        }
    }

    public void printBacktrack()  {
        for (int i = 1;i < maze.length - 1;++ i) {
            for (int j = 1;j < maze[i].length - 1;++ j) {
                System.out.print(backtrack[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }

    public void backTracking(Node tmp) {
        if (tmp.equals(startPoint)) {
            System.out.println("Backtracking finish!");
            return;
        }
        else {
            if (!tmp.equals(endPoint)) maze[tmp.x][tmp.y] = 9;
            // System.out.println(tmp.toString());
            backTracking(backtrack[tmp.x][tmp.y]);
        }
    }

    public boolean findWay() {
        stack.push(startPoint);
        boolMaze[startPoint.x][startPoint.y] = false;

        while (!stack.empty()) {
            Node temp = stack.peek();
            // System.out.println(temp.toString());    
            boolMaze[temp.x][temp.y] = false;

            stack.pop();

            for (int i = 0;i < 4;++ i) {
                if (canGo(new Node(temp.x + dx[i], temp.y + dy[i]))) {
                    backtrack[temp.x + dx[i]][temp.y + dy[i]] = temp;
                    stack.push(new Node(temp.x + dx[i], temp.y + dy[i]));
                }
            } 

        }
        
        return !boolMaze[endPoint.x][endPoint.y];
    }

    public boolean canGo(Node t) {
        return boolMaze[t.x][t.y];
    }

    public boolean[][] getBoolMaze() {
        return boolMaze;
    }

    public void setBoolMaze(boolean[][] boolMaze) {
        this.boolMaze = boolMaze;
    }

    public Node[][] getBacktrack() {
        return backtrack;
    }

    public void setBacktrack(Node[][] backtrack) {
        this.backtrack = backtrack;
    }

}