/* NomNom created on 4/28/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class UnsortedArrayPriorityQueue <K extends Comparable, E extends Comparable> implements
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

        @Override
        public String toString() {
            return "ArrEntry{" +
                    "key=" + key +
                    ", element=" + element +
                    '}';
        }
    }

    ArrEntry<K,E>[] array;
    int n = 0;
    int defaultsize = 1000000;

    public UnsortedArrayPriorityQueue() {
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

    @Override
    public void insert(Entry entry) {
        if (n == defaultsize)
            return;
        array[n] = new ArrEntry(entry.getKey(), entry.getValue());
        n += 1;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (n == defaultsize)
            return;
        array[n] = new ArrEntry(o, o2);
        n += 1;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        ArrEntry result = new ArrEntry(array[0].getKey(), array[0].getValue());
        int index = 0;
        for (int i = 1;i < n;++ i) {
            if (array[i].getKey().compareTo(result.getKey()) < 0) {
                result = array[i];
                index = i;
            }
            else if (array[i].getKey().compareTo(result.getKey()) == 0) {
                if (array[i].getValue().compareTo(result.getValue()) < 0) {
                    result = array[i];
                    index = i;
                }
            }
        }
        for (int i = index;i < n - 1;++ i) {
            array[i] = array[i + 1];
        }
        -- n;
        return (Entry) result;
    }

    @Override
    public Entry min() {
        if (isEmpty()) return null;
        ArrEntry result = array[0];
        for (int i = 1;i < n;++ i) {
            if (array[i].getKey().compareTo(result.getKey()) < 0) {
                result = array[i];
            }
            else if (array[i].getKey().compareTo(result.getKey()) == 0) {
                if (array[i].getValue().compareTo(result.getValue()) < 0) {
                    result = array[i];
                }
            }
        }
        return (Entry) result;
    }
}
