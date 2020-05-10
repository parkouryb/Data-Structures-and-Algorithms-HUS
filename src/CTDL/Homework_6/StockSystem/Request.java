/* NomNom created on 5/9/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem;

import CTDL.Homework_6.StockSystem.Stock.Stock;

import java.util.PriorityQueue;

public class Request implements Comparable {
    private String code;
    private int value;
    private double price;

    public Request(String code, int value, double price) {
        this.code = code;
        this.value = value;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Request{" +
                "code='" + code + '\'' +
                ", value=" + value +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Request a = (Request) o;
        if (this.price != a.getPrice()) {
            if (this.price < a.getPrice()) return 1;
            else return -1;
        }
        return 0;
    }
}
