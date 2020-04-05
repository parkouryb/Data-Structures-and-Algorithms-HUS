package CTDL.Homework_4.Bank;


import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Customer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private Integer POISON;
    private int N_POISON_PILL_PER_Customer;
    private int identity = 0;


    public Customer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public Customer(BlockingQueue<Integer> queue, Integer POISON, int identity, int n_POISON_PILL_PER_Customer) {
        this.queue = queue;
        this.POISON = POISON;
        this.identity = identity;
        this.N_POISON_PILL_PER_Customer = n_POISON_PILL_PER_Customer;
    }

    public void run() {
        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            while (true) {
                try {
                    for (int i = 0;i < N_POISON_PILL_PER_Customer;++ i) {
                        System.out.println(identity + " - puts poison pill.");
                        queue.put(POISON);
                    }
                    break;
                } catch (InterruptedException e) {
                    //...
                }
            }

        }
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int time = random.nextInt(2000); //  get random time
            System.out.println("[Customer] " + identity + " Put : " + time);
            queue.put(time);
        }
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}