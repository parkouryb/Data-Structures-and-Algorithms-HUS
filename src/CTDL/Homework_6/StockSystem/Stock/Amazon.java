/* NomNom created on 5/9/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem.Stock;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Amazon implements Stock {
    private String code = "AMZ";
    private int price;
    private int tradeID = 0;

    public Amazon() {
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public int tradeID() {
        return this.tradeID;
    }

    @Override
    public String toString() {
        return "Amazon{" +
                "code='" + code + '\'' +
                '}';
    }
}
