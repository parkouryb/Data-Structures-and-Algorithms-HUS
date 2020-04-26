/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

import CTDL.Homework_4.Maze.Node;

public class SortedLinkedPriorityQueue<K extends Comparable, E extends Comparable>
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

    public NodeEntry head;
    public NodeEntry tail;
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
            return;
        }

        NodeEntry ptr = head;
        NodeEntry temp = new NodeEntry(entry.getKey(), entry.getValue());
        K keyH = (K) head.getKey();

        if (keyH.compareTo(temp.getKey()) > 0) {
            temp.next = head;
            head = temp;
        }
        else {
            K key = (K) ptr.getKey();
            E elm = (E) ptr.getValue();
            NodeEntry prePtr = null;
            while (ptr.next != null && (key.compareTo(temp.getKey()) < 0 ||
                    (key.compareTo(temp.getKey()) == 0 && elm.compareTo(temp.getValue()) > 0))) {
                prePtr = ptr;
                ptr = ptr.next;
                key = (K) ptr.getKey();
                elm = (E) ptr.getValue();
            }

            key =(K) ptr.getKey();
            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    NodeEntry ptrNext = ptr.next;
                    if (ptrNext == null) {
                        tail = temp;
                        ptr.next = tail;
                        tail.next = null;
                    }
                    else {
                        ptr.next = temp;
                        temp.next = ptrNext;
                    }
                }
                else {
                    if (elm.compareTo(temp.getValue()) > 0) {
                        NodeEntry ptrNext = ptr.next;
                        ptr.next = temp;
                        temp.next = ptrNext;
                    }
                    else {
                        if (prePtr == null) {
                            NodeEntry oldHead = head;
                            head = temp;
                            head.next = oldHead;
                        }
                        else {
                            prePtr.next = temp;
                            temp.next = ptr;
                        }

                    }
                }
            }
            else {
                prePtr.next = temp;
                temp.next = ptr;
            }
        }
        ++ n;
    }

    @Override
    public void insert(Object o, Object o2) {
        if (isEmpty()) {
            head = new NodeEntry(o, o2);
            tail = new NodeEntry(o, o2);
            return;
        }

        NodeEntry ptr = head;
        NodeEntry temp = new NodeEntry(o, o2);
        K keyH = (K) head.getKey();

        if (keyH.compareTo(temp.getKey()) > 0) {
            temp.next = head;
            head = temp;
        }
        else {
            K key = (K) ptr.getKey();
            E elm = (E) ptr.getValue();
            NodeEntry prePtr = null;
            while (ptr.next != null && (key.compareTo(temp.getKey()) < 0 ||
                    (key.compareTo(temp.getKey()) == 0 && elm.compareTo(temp.getValue()) > 0))) {
                prePtr = ptr;
                ptr = ptr.next;
                key = (K) ptr.getKey();
                elm = (E) ptr.getValue();
            }

            key =(K) ptr.getKey();
            if (key.compareTo(temp.getKey()) <= 0) {
                if (key.compareTo(temp.getKey()) < 0) {
                    NodeEntry ptrNext = ptr.next;
                    ptr.next = temp;
                    temp.next = ptrNext;
                }
                else {
                    if (elm.compareTo(temp.getValue()) > 0) {
                        NodeEntry ptrNext = ptr.next;
                        if (ptrNext == null) {
                            tail = temp;
                            ptr.next = tail;
                            tail.next = null;
                        }
                        else {
                            ptr.next = temp;
                            temp.next = ptrNext;
                        }
                    }
                    else {
                        if (prePtr == null) {
                            NodeEntry oldHead = head;
                            head = temp;
                            head.next = oldHead;
                        }
                        else {
                            prePtr.next = temp;
                            temp.next = ptr;
                        }

                    }
                }
            }
            else {
                prePtr.next = temp;
                temp.next = ptr;
            }
        }
        ++ n;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry oldHead = head;
        if (head.next != null)
            head = head.next;
        else{
            tail = null;
            head = null;
        }
        -- n;
        return (Entry) oldHead;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }

        return (Entry) head;
    }
}
