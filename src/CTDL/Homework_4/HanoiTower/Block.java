package CTDL.Homework_4.HanoiTower;

public class Block{
    private int size;
    private Block next;

    public Block(int size, Block next) {
        super();
        this.size = size;
        this.next = next;
    }

    public Block(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Block getNext() {
        return next;
    }

    public void setNext(Block next) {
        this.next = next;
    }

}