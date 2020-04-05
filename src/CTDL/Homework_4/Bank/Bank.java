package CTDL.Homework_4.Bank;

import java.util.LinkedList;
import java.util.Queue;

/// Giới thiệu:
/// Nếu bạn muốn sửa có bao nhiêu khách thì bạn có thể vào file Customer.java
/// tìm hàm process chỉnh ở vòng lặp, mình đang để có 20 khách để tiến trình có thể
/// chạy nhanh hơn, còn số time random của 1 số khách thì cũng có thể chỉnh sửa thẳng
/// trong hàm process đó luôn, mình  đang để mặc định random trong 2000 ms
/// đây là bài tập dựa trên lập trình đa luồng, cụ thể đây chính là bài toán m-producers and n-customers
/// à do mình dùng đa luồng để xử lý bài toán nên hãy coi banker có tầm 5 - 8 người thôi nhé :v :v :v


public class Bank {
    public static void main(String[] args) throws InterruptedException {
        /// Customers đại diện cho cửa đón khách vậy
        /// hiện tại mình để 1 cửa đón khách và khách qua đây sẽ nhận 1 id
        /// bankers là những người xử lý vấn đề
        /// posion là các id để mình có thể break đc cái luồng của mình
        int N_CUSTOMERS = 1;
        int N_BANKERS = 5;
        int N_POISON_PILL_PER_CUSTOMERS = N_BANKERS / N_CUSTOMERS;
        int N_POISON_PILL_REMAIN = N_BANKERS % N_CUSTOMERS;

        System.out.println("N_PRODUCERS : " + N_CUSTOMERS);
        System.out.println("N_CONSUMERS : " + N_BANKERS);
        System.out.println("N_POISON_PILL_PER_PRODUCER : " + N_POISON_PILL_PER_CUSTOMERS);
        System.out.println("N_POISON_PILL_REMAIN : " + N_POISON_PILL_REMAIN);

        /// tạo queue với size là compacity, tức là số người tối đa trong hàng đợi.
        BlockingQueue<Integer> queue = new BlockingQueue<Integer>(10);
        Integer poison = -1;
        // ngân hàng bắt đầu làm việc
        Thread[] Customers = new Thread[N_CUSTOMERS];
        Thread[] Bankers = new Thread[N_BANKERS];
        Banker[] bankers = new Banker[N_BANKERS];

        for (int i = 0;i < N_CUSTOMERS - 1;++ i) {
            Customers[i] = new Thread(new Customer(queue, poison, i, N_POISON_PILL_PER_CUSTOMERS));
            Customers[i].start();
        }
        Customers[N_CUSTOMERS - 1] = new Thread(new Customer(queue, poison, N_CUSTOMERS - 1, N_POISON_PILL_PER_CUSTOMERS +  N_POISON_PILL_REMAIN));
        Customers[N_CUSTOMERS - 1].start();

        // các banker sẽ tiếp nhận thông tin
        for (int i = 0;i < N_BANKERS;++ i) {
            bankers[i] = new Banker(queue, poison, i);
            Bankers[i] = new Thread(bankers[i]);
            Bankers[i].start();
        }

        for (int i = 0;i < N_CUSTOMERS;++ i) Customers[i].join();
        for (int i = 0;i < N_BANKERS;++ i) Bankers[i].join();

        // bạn có thể lấy các thông tin của bankers tại dưới này, sau join
        // bằng các hàm trong class Banker
        // ví dụ lấy tổng số khách của banker 0 và số thời gian làm của banker 3
        System.out.println(bankers[0].getTotal_guest() + " " + bankers[3].getTotal_work_time());
    }
}
