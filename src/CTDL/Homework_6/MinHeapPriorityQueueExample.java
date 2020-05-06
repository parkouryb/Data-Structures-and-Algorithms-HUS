/* NomNom created on 4/27/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class MinHeapPriorityQueueExample {
    public static void addData(MinHeapPriorityQueue pq) {
        pq.insert("A", 1);
        pq.insert("B", 2);
        pq.insert("C", 3);
        pq.insert("F", 4);
        pq.insert("A", 5);
        pq.insert("B", 6);
        pq.insert("A", 7);
        pq.insert("D", 8);
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue pq = new MinHeapPriorityQueue<>();
        addData(pq);
//        for (int i = 0;i < pq.size();++ i) {
//            System.out.print(pq.heapPQ[i] + " ");
//        }

        while (!pq.isEmpty()) {
            System.out.println("Top : " + pq.top());
            Entry result = pq.removeTop();
            System.out.println("result : " + result);
        }
    }
}
