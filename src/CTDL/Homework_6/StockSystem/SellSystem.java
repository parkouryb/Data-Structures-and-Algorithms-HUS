/* NomNom created on 5/9/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem;

import CTDL.Homework_6.StockSystem.Stock.Shares;

import java.util.*;

public class SellSystem {

    Map<String, PriorityQueue<Request>> sellSystem = new HashMap<>();

    public SellSystem() {
        for (Shares share : Shares.values()) {
            sellSystem.put(share.toString(), new PriorityQueue<Request>(Collections.reverseOrder()));
        }
    }


}
