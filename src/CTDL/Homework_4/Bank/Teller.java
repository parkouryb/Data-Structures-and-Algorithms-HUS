package CTDL.Homework_4.Bank;


import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Teller implements Runnable {

    private final BlockingQueue<Integer> queue;
    private Integer POISON;


    public Teller(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public Teller(BlockingQueue<Integer> queue, Integer POISON) {
        this.queue = queue;
        this.POISON = POISON;
    }

    public void run() {
        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            while (true) {
                try {
                    queue.put(POISON);
                    break;
                } catch (InterruptedException e) {
                    //...
                }
            }

        }
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("[Producer] Put : " + i);
            queue.put(i);
            System.out.println("[Producer] Queue remainingCapacity : " + queue.size());
            Thread.sleep(100);
        }
    }

}