package CTDL.Homework_4.Bank;


import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Banker implements Runnable {

    private final BlockingQueue<Integer> queue;
    private Integer POISON;
    private int identity;
    private int total_guest = 0;
    private int total_work_time = 0;

    Banker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public Banker(BlockingQueue<Integer> queue, Integer POISON, int identity) {
        this.queue = queue;
        this.POISON = POISON;
        this.identity = identity;
    }

    public void run() {
        try {
            while (true) {
                Integer take = queue.take();
                // if this is a poison pill, break, exit
                if (take == POISON) {
                    System.out.println("Banker" + identity + " is finished");
                    break;
                }
                process(take);
                System.out.println("[Consumer] " + identity + " release.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void process(Integer take) throws InterruptedException {
        System.out.println("[Banker] " + identity + " take : " + take);
        ++ total_guest;
        total_work_time += take;
        Thread.sleep(take);
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getTotal_guest() {
        return total_guest;
    }

    public void setTotal_guest(int total_guest) {
        this.total_guest = total_guest;
    }

    public int getTotal_work_time() {
        return total_work_time;
    }

    public void setTotal_work_time(int total_work_time) {
        this.total_work_time = total_work_time;
    }
}