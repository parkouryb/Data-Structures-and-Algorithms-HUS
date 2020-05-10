/* NomNom created on 5/9/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem;

import CTDL.Homework_6.StockSystem.Stock.*;

import java.util.*;

public class Main {
    static Amazon amz = new Amazon();
    static Apple apl = new Apple();
    static Microsoft mcr = new Microsoft();

    static SellSystem sellSystem = new SellSystem();
    static BuySystem buySystem = new BuySystem();
    static Map<String, PriorityQueue<Request>> sellOrderSystem = sellSystem.sellSystem;
    static Map<String, PriorityQueue<Request>> buyOrderSystem = buySystem.buySystem;

    public static void buildSellOrders() {
        sellOrderSystem.get("AMZ").add(new Request("@AMZ", 100, 1000.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1000.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1000.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1000.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 900.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 900.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 950.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 950.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 950.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1050.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1100.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1100.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1100.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1100.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1500.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1200.0));
        sellOrderSystem.get("AMZ").add(new Request("@AMZ",100, 1350.0));

        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2000.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 15000.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 500.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 1200.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 900.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 1800.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 950.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 950.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 950.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 1050.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 1100.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2100.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 3100.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2100.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2500.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2200.0));
        sellOrderSystem.get("APL").add(new Request("@APL", 100, 2350.0));

        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1000.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1000.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1000.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1000.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 900.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 900.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 950.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 950.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 950.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1050.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1100.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1100.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1100.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1100.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1500.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1200.0));
        sellOrderSystem.get("MCR").add(new Request("@MCR", 100, 1350.0));

    }



    public static void main(String[] args) {
        buildSellOrders();
        // cái này để in ra các sell orders trong priority queue
        for (Shares share: Shares.values()) {
            PriorityQueue pq = sellOrderSystem.get(share.toString());
            System.out.println(share.toString() + "\n" + pq.toString());
            System.out.println("-------------------------------");
        }


        // cái này là để bán bán mua mua <3
        User boss = new User("BOSSS");
        boss.addMoney(100000000);
        boss.buyStock("AMZ", 99999, sellOrderSystem, buyOrderSystem);
        boss.buyStock("AMZ", 99999, sellOrderSystem, buyOrderSystem);
        boss.buyStock("MCR", 99999, sellOrderSystem, buyOrderSystem);
        boss.buyStock("APL", 99999, sellOrderSystem, buyOrderSystem);
        boss.buyStock("APL", 99999, sellOrderSystem, buyOrderSystem);
        boss.buyStock("APL", 99999, sellOrderSystem, buyOrderSystem);


        User user = new User("18001131");
        user.addMoney(200000);

        user.buyStock("AMZ", 1000, sellOrderSystem, buyOrderSystem);
        user.buyStock("AMZ", 20, sellOrderSystem, buyOrderSystem);
        user.buyStock("MCR", 30, sellOrderSystem, buyOrderSystem);
        user.buyStock("APL", 40, sellOrderSystem, buyOrderSystem);
        user.buyStock("APL", 40, sellOrderSystem, buyOrderSystem);
        user.buyStock("APL", 40, sellOrderSystem, buyOrderSystem);
        user.buyStock("MCR", 30, sellOrderSystem, buyOrderSystem);
        user.buyStock("MCR", 30, sellOrderSystem, buyOrderSystem);
        user.buyStock("MCR", 310, sellOrderSystem, buyOrderSystem);
        user.buyStock("MCR", 310, sellOrderSystem, buyOrderSystem);
        user.buyStock("AMZ", 20, sellOrderSystem, buyOrderSystem);
        user.buyStock("AMZ", 210, sellOrderSystem, buyOrderSystem);
        user.buyStock("AMZ", 20, sellOrderSystem, buyOrderSystem);
        user.buyStock("AMZ", 120, sellOrderSystem, buyOrderSystem);

        // cái này để in ra các buy orders trong priority queue
        for (Shares share: Shares.values()) {
            PriorityQueue pq = buyOrderSystem.get(share.toString());
            System.out.println(share.toString() + "\n" + pq.toString());
            System.out.println("-------------------------------");
        }

        // in  ra các order của user còn đang tồn đọng trong buySystem.
        System.out.println("User orders: ");
        System.out.println(user.getOrders().toString());

        System.out.println("Boss orders: ");
        System.out.println(boss.getOrders().toString());

        // Bây giờ thì mình sẽ thử delete vài order của user nào <3
        user.deleteOrder(0, buyOrderSystem);
        user.deleteOrder(0, buyOrderSystem);
        user.deleteOrder(0, buyOrderSystem);
        System.out.println("User orders: ");
        System.out.println(user.getOrders().toString());

        // Bây giờ là in ra số cổ phiếu mỗi ông nắm giữ
        System.out.println("User: ");
        System.out.println(user.getShares().toString());

        System.out.println("Boss: ");
        System.out.println(boss.getShares().toString());

        // giàu quá rồi thì giờ phải bán thôi
        user.sellStock("AMZ", 10, 100000, sellOrderSystem);
        user.sellStock("MCR", 10, 100000, sellOrderSystem);
        user.sellStock("APL", 10, 100000, sellOrderSystem);

        boss.sellStock("AMZ", 100, 1, sellOrderSystem);
        boss.sellStock("MCR", 100, 1, sellOrderSystem);
        boss.sellStock("APL", 100, 1, sellOrderSystem);

        // cập nhật lại tài sản nào <3
        System.out.println("User: ");
        System.out.println(user.getShares().toString());

        System.out.println("Boss: ");
        System.out.println(boss.getShares().toString());

        // cập nhật lại bảng bán thôi nhỉ :))
        for (Shares share: Shares.values()) {
            PriorityQueue pq = sellOrderSystem.get(share.toString());
            System.out.println(share.toString() + "\n" + pq.toString());
            System.out.println("-------------------------------");
        }
    }

}
