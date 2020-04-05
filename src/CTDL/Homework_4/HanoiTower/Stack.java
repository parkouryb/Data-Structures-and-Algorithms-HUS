package CTDL.Homework_4.HanoiTower;

import java.awt.*;

import javax.swing.JPanel;

public class Stack{
    private Block headBlock;

    public Block getHeadBlock() {
        return this.headBlock;
    }

    public void setHeadBlock(Block headBlock) {
        this.headBlock = headBlock;
    }

    public void push(Block block) {
        if (headBlock == null) {
            headBlock = block;
        }
        else {
            Block currentBlock = headBlock;
            while (currentBlock.getNext() != null) {
                currentBlock = currentBlock.getNext();
            }
            currentBlock.setNext(block);
        }
    }

    public Block pop() {
        Block popBlock = null;

        if (count() == 1) {
            popBlock = headBlock;
            headBlock = null;
        }
        else {
            if (count() > 1) {
                Block currentBlock = headBlock;
                for (int i = 1;i < count() - 1;++ i) {
                    currentBlock = currentBlock.getNext();
                }
                popBlock = currentBlock.getNext();
                currentBlock.setNext(null);
            }
        }
        return popBlock;
    }

    public Block peek() {
        if (count() > 0) {
            Block currentBlock = headBlock;
            while (currentBlock.getNext() != null) {
                currentBlock = currentBlock.getNext();
            }
            return currentBlock;
        }
        else return null;
    }

    public int count() {
        int count = 0;
        Block currentBlock = headBlock;
        while (currentBlock != null) {
            ++ count;
            currentBlock = currentBlock.getNext();
        }
        return count;
    }

    public void drawBlocks(Graphics g, int x) {
        Block currentBlock = headBlock;
        for (int i = 0;i < count();i ++) {
            int xPos = x + (100 - currentBlock.getSize()) / 2;
            int yPos = 181 - (i * 20);

            g.setColor(Color.BLUE);
            g.drawRect(xPos, yPos, currentBlock.getSize(), 19);
            g.setColor(Color.RED);
            g.fillRect(xPos + 1, yPos + 1, currentBlock.getSize() - 1, 18);

            currentBlock = currentBlock.getNext();
        }
    }
}