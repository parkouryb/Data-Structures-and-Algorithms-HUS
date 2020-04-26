/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E>
        implements PriorityQueueInterface {
    protected static class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e){
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
            return "Entry{" + key + ", " + element + "}";
        }
    }

    public NodeEntry<K,E> head;
    public NodeEntry<K,E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(Entry entry) {
        if (isEmpty()) {
            head = new NodeEntry(entry.getKey(), entry.getValue());
            tail = new NodeEntry(entry.getKey(), entry.getValue());
            ++ n;
            return;
        }
        NodeEntry oldHead = head;
        head = new NodeEntry(entry.getKey(), entry.getValue());
        head.next = oldHead;
        ++ n;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (isEmpty()) {
            head = new NodeEntry(o, o2);
            tail = new NodeEntry(o, o2);
            ++ n;
            return;
        }
        NodeEntry oldHead = head;
        head = new NodeEntry(o, o2);
        head.next = oldHead;
        ++ n;
    }

    @Override
    public Entry removeMin() {
        K minKey = null;
        if (isEmpty()) {
            return (Entry) null;
        }
        NodeEntry ptr = head;
        NodeEntry minPtr = head, preMinPtr = null;
        minKey = (K) ptr.key;

        // find min
        while (ptr.next != null) {
            K keyPtr = (K) ptr.next.key;
            if (keyPtr.compareTo(minKey) < 0) {
                minPtr = ptr.next;
                preMinPtr = ptr;
                minKey = keyPtr;
            }
            ptr = ptr.next;
        }

        // remove
        if (preMinPtr == null) {
            if (minPtr.next != null) {
                head = minPtr.next;
            }
            else {
                head = null;
                tail = null;
            }

        }
        else {
            if (minPtr.next != null) {
                preMinPtr.next = minPtr.next;
            }
            else {
                preMinPtr.next = null;
                tail = preMinPtr;
            }
        }
        -- n;

        return (Entry) minPtr;
    }

    @Override
    public Entry min() {
        K minKey = null;
        if (isEmpty()) {
            return (Entry) null;
        }
        NodeEntry ptr = head;
        NodeEntry minPtr = head, preMinPtr = null;
        minKey = (K) ptr.key;

        // find min
        while (ptr.next != null) {
            K keyPtr = (K) ptr.next.key;
            if (keyPtr.compareTo(minKey) < 0) {
                minPtr = ptr.next;
                preMinPtr = ptr;
                minKey = keyPtr;
            }
            ptr = ptr.next;
        }
        return (Entry) minPtr;
    }
}
