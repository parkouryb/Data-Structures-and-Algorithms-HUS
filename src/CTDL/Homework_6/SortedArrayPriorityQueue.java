/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class SortedArrayPriorityQueue <K extends Comparable, E extends Comparable> implements
        PriorityQueueInterface {

    protected static class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }
    }

    ArrEntry<K,E> [] array;
    int n = 0;
    int defaultsize = 1000000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    public SortedArrayPriorityQueue(int defaultsize) {
        this.defaultsize = defaultsize;
        array = new ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public void append(int index) {
        for (int i = n;i > index;-- i) {
            array[i] = array[i - 1];
        }
    }

    @Override
    public void insert(Entry entry) {
        if (n == defaultsize) {
            return;
        }
        if (isEmpty()) {
            array[0] = new ArrEntry(entry.getKey(), entry.getValue());
            ++ n;
            return;
        }

        int ptr = 0;
        K keyH = (K) array[ptr].getKey();
        ArrEntry temp = new ArrEntry(entry.getKey(), entry.getValue());

//        System.out.println("start " + temp.getKey() + " " + temp.getValue());
        if (keyH.compareTo(temp.getKey()) > 0) {
            append(0);
            array[0] = temp;
        }
        else {
            K key = (K) array[ptr].getKey();
            E elm = (E) array[ptr].getValue();

            for (int i = 0;i < n;++ i) {
                if (key.compareTo(temp.getKey()) < 0 ||
                    (key.compareTo(temp.getKey()) == 0 && elm.compareTo(temp.getValue()) < 0)) {

                    ptr = i;
                    key = (K) array[i].getKey();
                    elm = (E) array[i].getValue();
                }
                else {
                    break;
                }
            }

            key = (K) array[ptr].getKey();
            elm = (E) array[ptr].getValue();

            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    array[ptr + 1] = temp;
                }
                else {
//                    System.out.println("process " + ptr + " " + temp.getKey());
                    if (elm.compareTo(temp.getValue()) >= 0) {
                        append(ptr);
                        array[ptr] = temp;
                    }
                    else {
                        append(ptr + 1);
                        array[ptr + 1] = temp;
                    }
                }
            }
            else {
                append(ptr);
                array[ptr] = temp;
            }
        }
        ++ n;
//        toArray();
}

    public void toArray() {
        for (int i = 0;i < n;++ i) {
            ArrEntry x = array[i];
            System.out.println(i + ": " + x.getKey() + " " + x.getValue());
        }
        System.out.println("");
    }

    @Override
    public void insert(Object o, Object o2) {
        if (n == defaultsize) {
            return;
        }
        if (isEmpty()) {
            array[0] = new ArrEntry(o, o2);
            ++ n;
            return;
        }

        int ptr = 0;
        K keyH = (K) array[ptr].getKey();
        ArrEntry temp = new ArrEntry(o, o2);

//        System.out.println("start " + temp.getKey() + " " + temp.getValue());
        if (keyH.compareTo(temp.getKey()) > 0) {
            append(0);
            array[0] = temp;
        }
        else {
            K key = (K) array[ptr].getKey();
            E elm = (E) array[ptr].getValue();

            for (int i = 0;i < n;++ i) {
                if (key.compareTo(temp.getKey()) < 0 ||
                        (key.compareTo(temp.getKey()) == 0 && elm.compareTo(temp.getValue()) < 0)) {

                    ptr = i;
                    key = (K) array[i].getKey();
                    elm = (E) array[i].getValue();
                }
                else {
                    break;
                }
            }

            key = (K) array[ptr].getKey();
            elm = (E) array[ptr].getValue();

            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    array[ptr + 1] = temp;
                }
                else {
//                    System.out.println("process " + ptr + " " + temp.getKey());
                    if (elm.compareTo(temp.getValue()) >= 0) {
                        append(ptr);
                        array[ptr] = temp;
                    }
                    else {
                        append(ptr + 1);
                        array[ptr + 1] = temp;
                    }
                }
            }
            else {
                append(ptr);
                array[ptr] = temp;
            }
        }
        ++ n;
//        toArray();
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        ArrEntry result = array[0];
        for (int i = 0;i < n - 1;++ i) array[i] = array[i + 1];
        -- n;
        return (Entry) result;
    }

    @Override
    public Entry min() {
        return (Entry) array[0];
    }
}
