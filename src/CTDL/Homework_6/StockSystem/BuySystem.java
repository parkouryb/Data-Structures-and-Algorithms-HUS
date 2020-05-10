/* NomNom created on 5/10/2020 inside the package - CTDL.Homework_6.StockSystem */

package CTDL.Homework_6.StockSystem;

import CTDL.Homework_6.StockSystem.Stock.Shares;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BuySystem {
    Map<String, PriorityQueue<Request>> buySystem = new HashMap<>();

    public BuySystem() {
        for (Shares share : Shares.values()) {
            buySystem.put(share.toString(), new PriorityQueue<Request>());
        }
    }
}
