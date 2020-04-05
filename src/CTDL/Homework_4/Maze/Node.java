package CTDL.Homework_4.Maze;

public class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object a){
        Node b = (Node)(a);
        return this.x == b.x && this.y == b.y;
    }

    @Override
    public String toString() {
        return "Node [x=" + x + ", y=" + y + "]";
    }


}