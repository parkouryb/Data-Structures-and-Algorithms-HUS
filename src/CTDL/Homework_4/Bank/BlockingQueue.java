package CTDL.Homework_4.Bank;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    // có thể coi biến compacity là biến đại diện cho số người chứa trong ngân hàng
    // kiểu dạng người đang chờ để tới turn mình xử lý công việc với banker vậy
    // defaut = 5
    private int compacity = 5;
    private final LinkedList<T> items = new LinkedList<>();

    public BlockingQueue() {
    }

    public BlockingQueue(int compacity) {
        this.compacity = compacity;
    }

    public synchronized void put(T value) throws InterruptedException {
        while (items.size() == compacity) {
            System.out.println("Queue is full");
            wait();
        }
        items.addLast(value);
        notifyAll();
    }

    public synchronized T peek() {
        return items.peek();
    }

    /**
     *
     * @return First guy and remove it
     * @throws InterruptedException
     */
    public synchronized T take() throws InterruptedException {
        while (items.size() == 0) {
            System.out.println("Queue is empty");
            wait();
        }
        T item = items.remove();
        notifyAll();
        return item;
    }

    /**
     *
     * @return size of blocking queue
     */
    public synchronized int size() {
        return items.size();
    }
}