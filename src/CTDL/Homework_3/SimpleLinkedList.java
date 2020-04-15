package CTDL.Homework_3;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void add(T data) {
        ++ n;
        Node temp = new Node(data);
        if (top == null) {
            top = temp;
            bot = temp;
        } else {
            temp.next = top;
            top = temp;
        }
    }

    public void addBot(T data) {
        ++ n;
        Node temp = new Node(data);
        Node ptr;
        if (top == null) {
            top = temp;
            bot = temp;
        } else {
            ptr = top;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
            bot = temp;
        }
    }

    public T get(int i) {
        if (isEmpty() || i < -1 || i >= size()) return null;

        int k = 0;
        Node ptr = top;
        while (ptr != null && k != i) {
            ++ k;
            ptr = ptr.next;
        }
        return ptr.data;
    }

    public void set(int i, T data) {
        if (isEmpty()) {
            System.out.println("Position is not available");
        }
        else {
            int k = 0;
            Node ptr = top;
            while (ptr != null && k != i) {
                ptr = ptr.next;
                ++ k;
            }

            if (k != i) {
                System.out.println("Position is not available");
            }
            else {
                ptr.data = data;
            }

        }
    }

    public boolean isContain(T data) {
        Node ptr = top;
        if (data.equals(ptr.data)) return true;
        while (ptr != null && data != ptr.data) {
            if (data.equals(ptr.data)) return true;
            ptr = ptr.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public T removeTop() {
        T res = null;
        if (top == null) {
            System.out.println("Nothing to delete!");
        }
        else {
            res = top.data;

            if (size() > 1) {
                top = top.next;
            }
            else {
                top = null;
                bot = null;
            }
            -- n;
        }
        return res;
    }

    public T removeBot() {
        T res = null;
        if (bot == null) {
            System.out.println("Nothing to delete!");
        }
        else {
            Node ptr = top;
            if (size() > 1) {
                while (ptr.next.next != null) {
                    ptr = ptr.next;
                }
                res = ptr.next.data;
                ptr.next = ptr.next.next;
                bot = ptr;
                -- n;
            }
            else {
                top = bot = null;
                -- n;
            }

        }
        return res;
    }

    public void remove(T data) {
        if (isEmpty()) {
            System.out.println("nothing to delete!");
        }
        else {
            while (top != null && top.data.equals(data)) {
                if (data.equals(top.data)) {
                    removeTop();
                }

            }
            while (bot != null && bot.data.equals(data)) {
                if (data.equals(bot.data)) {
                    removeBot();
                }
            }

            if (isEmpty()) {
                return;
            }
            else {
                Node ptr = top.next;
                Node pre = top;
                if (ptr == null) {
                    if (pre.data.equals(data)) removeTop();
                    return;
                }
                while (ptr.next != null) {
                    if (ptr.data.equals(data)) {
                        pre.next = ptr.next;
                        -- n;
                    }
                    pre = pre.next;
                    ptr = ptr.next;
                }
            }

        }
    }
}