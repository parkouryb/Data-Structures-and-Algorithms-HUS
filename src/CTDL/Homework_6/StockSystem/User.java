/* NomNom created on 5/9/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem;

import CTDL.Homework_6.StockSystem.Stock.Stock;

import java.util.*;

public class User {
    public class Order{
        private String code;
        private Request a;

        public Order(String code, Request a) {
            this.code = code;
            this.a = a;
        }

        public String getCode() {
            return code;
        }

        public Request getA() {
            return a;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "code='" + code + '\'' +
                    ", a=" + a +
                    '}';
        }
    }

    private String userCode;
    private double money;
    // Các order tồn đọng trong buyOrders
    private ArrayList <Order> orders = new ArrayList<>();
    // Số cổ phiếu user sở hữu.
    private Map<String, Integer> shares = new HashMap<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Map<String, Integer> getShares() {
        return shares;
    }

    public User(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money = money;
    }

    public void buyStock(String code, double price, Map<String, PriorityQueue<Request>> sellOrderSystem, Map<String, PriorityQueue<Request>> buyOrderSystem) {
        PriorityQueue<Request> sellSystem = sellOrderSystem.get(code);
        PriorityQueue<Request> buySystem = buyOrderSystem.get(code);

        if (price > money) {
            System.out.println("Not enough money.");
            return;
        }
        Request buyRequest = new Request(userCode, 100, price);
        if (!sellSystem.isEmpty()) {
            Request a = (Request) sellSystem.peek();
            if (a.getPrice() <= price) {
                sellSystem.remove();
                this.money -= a.getPrice();
                // put to shares

                if (shares.containsKey(code))
                    shares.put(code, shares.get(code) + a.getValue());
                else
                    shares.put(code, a.getValue());
                System.out.println(userCode + " buy success: " + a.getPrice() + "$/100 " + code + ".");
            }
            else {
                System.out.println("Go to buy orders");
                buySystem.add(buyRequest);
                orders.add(new Order(code, buyRequest));
            }
        }
        else {
            System.out.println("Go to buy orders");
            buySystem.add(buyRequest);
            orders.add(new Order(code, buyRequest));
        }
    }

    public void sellStock(String code, int value, double price, Map<String, PriorityQueue<Request>> sellOrderSystem) {
        PriorityQueue<Request> sellSystem = sellOrderSystem.get(code);
        int f = value;
        if (value % 100 != 0) {
            System.out.println("Not smart enough for sell != 100, so sorry :(");
            return;
        }
        if (value > shares.get(code)) {
            System.out.println("Not enough for sell man :(");
            return;
        }
        while(value != 1) {
            sellSystem.add(new Request(userCode, 100, price));
            value /= 100;
        }
        shares.put(code, shares.get(code) - f);

        System.out.println(userCode + " sell success: " + f + " " + code);
    }

    public void deleteOrder(int index, Map<String, PriorityQueue<Request>> buyOrderSystem) {
        if (index < 0 && index >= orders.size()) {
            System.out.println("Not exist order.");
            return;
        }

        Request a = orders.get(index).getA();
        buyOrderSystem.get(orders.get(index).getCode()).remove(a);

        orders.remove(index);
        System.out.println("Remove complete.");

    }

    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", money='" + money + '\'' +
        '}';
    }

    public class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }
}
