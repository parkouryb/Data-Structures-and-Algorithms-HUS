/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class LPriotityQueuExample {
    public static void UnsortedExample() {
        UnsortedLinkedPriorityQueue pq = new UnsortedLinkedPriorityQueue();
        pq.insert("A", 12);
        pq.insert("W", 15);
        pq.insert("K", 21);
        pq.insert("L", 92);
        pq.insert("E", 11);

        UnsortedLinkedPriorityQueue.NodeEntry value;
        value = new UnsortedLinkedPriorityQueue.NodeEntry("B", 53);
        pq.insert(value);
        value = new UnsortedLinkedPriorityQueue.NodeEntry("H", 76);
        pq.insert(value);
        value = new UnsortedLinkedPriorityQueue.NodeEntry("M", 93);
        pq.insert(value);


        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            // debug line
            System.out.println("Head: " + pq.head.getKey() + " " + pq.head.getValue());
            System.out.println("Tail: " + pq.tail.getKey() + " " + pq.tail.getValue());

            System.out.println("Min: " + pq.min().getKey() + " " + pq.min().getValue());
            Entry result = pq.removeMin();
            System.out.println("removeMin: " + result.getKey() + " " + result.getValue());
            System.out.println("");
        }
    }

    public static void addData(SortedLinkedPriorityQueue pq) {
        SortedLinkedPriorityQueue.NodeEntry value;

        value = new SortedLinkedPriorityQueue.NodeEntry("A", 1);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("B", 9);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("B", 8);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 2);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("D", 5);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("B", 6);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("B", 11);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 9);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 19);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 21);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 1);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("C", 5);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("D", 5);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("F", 5);
        pq.insert(value);
        value = new SortedLinkedPriorityQueue.NodeEntry("A", 5);
        pq.insert(value);

        pq.insert("A", 12);
        pq.insert("B", 21);
        pq.insert("B", 76);
        pq.insert("C", 3);
        pq.insert("F", 0);
        pq.insert("C", 3);
        pq.insert("F", 12);

    }

    public static void SortedExample() {
        SortedLinkedPriorityQueue pq = new SortedLinkedPriorityQueue();

        addData(pq);
        SortedLinkedPriorityQueue.NodeEntry value;

        while (!pq.isEmpty()) {
            value = (SortedLinkedPriorityQueue.NodeEntry) pq.removeMin();
            System.out.println(value.getKey() + " " +  value.getValue());
        }
        addData(pq);

        while (!pq.isEmpty()) {
            // debug line
//            System.out.println("Head: " + pq.head.getKey() + " " + pq.head.getValue());
//            System.out.println("Tail: " + pq.tail.getKey() + " " + pq.tail.getValue());

            System.out.println("Min: " + pq.min().getKey() + " " + pq.min().getValue());
            Entry result = pq.removeMin();
            System.out.println("removeMin: " + result.getKey() + " " + result.getValue());
            System.out.println("");
        }
    }

    public static void testDot5() {
        SortedLinkedPriorityQueue pq = new SortedLinkedPriorityQueue();

        User user0 = new User.UserBuilder(1)
                .name("hieu")
                .build();
        User user1 = new User.UserBuilder(3)
                .name("trang")
                .build();
        User user2 = new User.UserBuilder(1)
                .name("dang")
                .build();
        User user3 = new User.UserBuilder(6)
                .name("nhung")
                .build();
        User user4 = new User.UserBuilder(2)
                .name("thanh")
                .build();
        User user5 = new User.UserBuilder(0)
                .name("tuan")
                .build();

        pq.insert("A", user0);
        pq.insert("A", user1);
        pq.insert("B", user2);
        pq.insert("C", user3);
        pq.insert("C", user4);
        pq.insert("A", user5);

        while(!pq.isEmpty()) {
            System.out.println("Min: " + pq.min().getKey() + " " + pq.min().getValue());
            Entry result = pq.removeMin();
            System.out.println("removeMin: " + result.getKey() + " " + result.getValue());
            System.out.println("");
        }
    }

    public static void sapq() {
        SortedArrayPriorityQueue pq = new SortedArrayPriorityQueue();
        SortedArrayPriorityQueue.ArrEntry value;

        value = new SortedArrayPriorityQueue.ArrEntry("A", 1);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("B", 1);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("B", 3);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("C", 3);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("B", 4);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("B", 0);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("B", 7);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("D", 6);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("F", 1);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("C", 1);
        pq.insert(value);
        value = new SortedArrayPriorityQueue.ArrEntry("C", 4);
        pq.insert(value);
        pq.insert("C", 6);

        while(!pq.isEmpty()) {
            System.out.println("Min: " + pq.min().getKey() + " " + pq.min().getValue());
            Entry result = pq.removeMin();
            System.out.println("removeMin: " + result.getKey() + " " + result.getValue());
            System.out.println("");
        }
    }

    public static void usapq() {
        UnsortedArrayPriorityQueue pq = new UnsortedArrayPriorityQueue();
        UnsortedArrayPriorityQueue.ArrEntry value;

        value = new UnsortedArrayPriorityQueue.ArrEntry("A", 1);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("B", 1);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("B", 3);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("C", 3);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("B", 4);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("B", 0);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("B", 7);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("D", 6);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("F", 1);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("C", 1);
        pq.insert(value);
        value = new UnsortedArrayPriorityQueue.ArrEntry("C", 4);
        pq.insert(value);
        pq.insert("C", 6);

        while(!pq.isEmpty()) {
            System.out.println("Min: " + pq.min());
            Entry result = pq.removeMin();
            System.out.println("removeMin: " + result.getKey() + " " + result.getValue());
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        usapq();
//        UnsortedExample();
//        SortedExample();
//        testDot5();
    }
}

//A 12
//A 5
//A 1
//B 76
//B 21
//B 11
//B 9
//B 8
//B 6
//C 21
//C 19
//C 9
//C 5
//C 3
//C 3
//C 2
//C 1
//D 5
//D 5
//F 12
//F 5
//F 0
